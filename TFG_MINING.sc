
sub miningMinoc(); By GHZATOMIC (para Mina TfG)
var t,x,y,dir,px,py
#uo.msg('bank')
#UO.AddObject ('CONTAINER')
#While UO.Targeting()
#   Wait(100)
#Wend
inicio:
#uo.usetype('0x103B')
t=3 #Quantos tiles seu char vai andar depois que minerar tudo a sua volta.
ChecarLimiteMinoc(488,18) #Limite X ou Y da Mina. #Quantos tiles seu char vai andar pra voltar depois de ultrapassar do limite.
uo.exec('useskill Hiding')
Wait(3800)
#IF (uo.weight >= 100) then #Peso maximo antes de comecar a guardar os Ores no Bank.
#   GuardarOres()
#endif
if UO.Life < UO.str then 
	uo.msg('guards all release guards !!!')
endif
for x = -2 to 2
	for y = -2 to 2
		denovo:
		UO.DeleteJournal()
		if ((y == 0) and (x == 0)) or ((num(x) == 2) and (num(y) == 2)) then
			goto jump
		endif
		uo.waittargettile('#0x400', str(uo.GetX() + x), str(uo.GetY() + y), STR(UO.GetZ('self')))
		uo.usetype('0x0E85')
		repeat
			#UO.print("Aguarde ...")
			wait(200)  
		until UO.InJournal("You put|You cann|target canc|You loosen|There is nothing|You have no line|That is too|Try mining")
		if UO.InJournal("There is nothing|You have no line|That is too|Try mining") then
			UO.print("ANDANDO ...")
			goto walk
		endif
		if not UO.InJournal("You cannot") then
			goto denovo
		endif
		UO.print("Tentando novamente ...")
        jump:
	next
next
walk:
px=UO.GetX('self')
py=UO.GetY('self')
dir=UO.Random(8)
while (t >= 0)
   uo.press(dir+33)
   wait(100)
   t=t-1
wend
if (px == UO.GetX('self')) and (py == UO.GetY('self')) then
   t=3
   goto walk
endif
goto inicio
end sub

Sub num(X)
	if X>0 then
		return X
	else
		return (-X)
	end if
end sub

sub ChecarLimite(limite,passos)
IF (UO.GetY('self') >= limite) then
uo.press(36)
wait(100)
uo.press(36)
while (passos >= 0)
wait(100)
uo.press(39)
passos=passos-1
wend
endif
end sub

sub teste()

ChecarLimiteMinoc(488,18)
end sub

sub ChecarLimiteMinoc(limite,passos) 
;uo.press(40); sudoeste
;uo.press(39); noroeste 
;uo.press(38); nordeste
;uo.press(37); sudeste
;uo.press(36); leste 
;uo.press(35); sul
;uo.press(34); oeste
;uo.press(33); norte
IF (UO.GetY('self') >= limite) then
uo.press(38);
wait(100)
uo.press(38)
uo.press(38);
uo.press(38);
while (passos >= 0)
wait(100)
uo.press(39); 
passos=passos-1
wend
endif
end sub



sub IrAteBankMinoc()

end sub

sub GuardarOres()
var n
DIM ID[12]
ID[1]='0x19B9'
ID[2]='0x19B8'
ID[3]='0x19BA'
ID[4]='0x19B7'
ID[5] = '0x0F16 CONTAINER'; amesthysts
ID[6] = '0x0F10 CONTAINER'; emerald
ID[7] = '0x0F0F CONTAINER'; star sapphire
ID[8] = '0x0F18 CONTAINER'; tourmaline
ID[9] = '0x0F26 CONTAINER'; diamond
ID[10] = '0x0F11 CONTAINER'; sapphire
ID[11] = '0x0F15 CONTAINER'; citrine
ID[12] = '0x0F13 CONTAINER'; rubi

uo.msg('bank')
wait(1000)
uo.useobject('CONTAINER')
wait(1000)
For n=5 To 12
if uo.count(MID(ID[n], 0, 6)) >=1 then
if n >= 6 then
wait(1600)
endif
UO.FindType(MID(ID[n], 0, 6),'-1','my');
uo.moveitem('finditem', '0', MID(ID[n], 7, 9))
endif
Next
For n=1 To 4
while uo.count(ID[n]) >= 1
wait(1600)
UO.FindType(ID[n],'-1','my')
uo.moveitem('finditem', '0', 'CONTAINER')
wend
Next
end sub

sub DropOre(cor)
var n
DIM OREID[4]
OREID[1]='0x19BA'
OREID[2]='0x19B8'
OREID[3]='0x19B7'
OREID[4]='0x19B9'
For n=1 to 4
if uo.count(OREID[n],cor) >=1 then
UO.FindType(OREID[n],cor,'my')
UO.MoveItem('finditem','-1','ground')
endif
Next
endsub
 