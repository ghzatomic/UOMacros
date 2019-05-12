# |x| FUNCTION |x| |x| COMMAND |x| HOTKEYS |x| ( EXEC ) |x| 
# > Warmode + Stealth = warmode 0 ; useskill 'Stealth' 
# > Cortar Corpo 
# > USAR BANDAGES 
# > EQUIPAR ITENS DA BAG 
# > Macro de se Buffar* ( Ao executar vc casta todas magias úteis de proteção em si: "Reactive Armor, Strength, Arch Protection e Magic Reflection" ) 
# > Macro de se Healar(2) ( Macro de se Healar com Loop infinito, ele vai ficar se healando com bandages, caso o HP fique <= 30 ele bebe life boost ) 
# > Macro de Healar um Target ( Macro de ficar aplicando bandages passivamente em um determinado target ) 
# > Soltar Wall em \ 
# > Soltar Wall em \ atras 
# > Soltar Wall em / atras 
# > Soltar Fire em \ 
# > Soltar Fire em / 
# > Soltar PF em / 
# > Soltar PF em \ 
# > Fexar "X" + "FF" 
# > Lootiar do Chao 
# > Cortar corpo 
# > Ping do Shard 


# ================= # 
# MACROS DE ARMAS # 
# ================= # 


# >> WAR MODE 
# >>>>>>>>>>>> 

sub War_Mode() 

uo.warmode(1) 

end sub 

# >> CORTAR O CORPO MAIS PERTO 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Cortar_Corpo() 

uo.waittargetground('0x2006') 
UO.Exec("usetype 0x0F51") 
end if 

end sub 

# >> TIRAR TODO O LOOT 
# >>>>>>>>>>>>>>>>>>>>> 

sub Zero() 

uo.undress() 
uo.msg (".disarm") 

end sub 

# >> SOLTAR MAGIA G.HEAL NO AMIGO NUMERO 1 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Magia_Heal_Amigo1() 

uo.cast("Greater Heal","Amigo1") 

endsub 

# >> SOLTAR MAGIA G. HEAL NO AMIGO NUMERO 2 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Magia_Heal_Amigo2() 

uo.cast("Greater ","Amigo2") 

endsub 

# >> SOLTAR MAGIA G.HEAL NO AMIGO NUMERO 3 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Magia_Heal_Amigo3() 

uo.cast("Greater Heal","Amigo3") 

endsub 

# >> SOLTAR MAGIA MAGIC ARROW NO AMIGO NUMERO 1 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Magia_MA_Amigo1() 

uo.cast("Magic Arrow","Amigo1") 

endsub 

# >> CRIAR HORSE COM SUMMON CREATURE 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Summon() 

uo.cast("Summ. Creature") 
uo.waittargetself() 


endsub 


# >> SOLTAR MAGIA MAGIC ARROW NO AMIGO NUMERO 3 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Magia_MA_Amigo3() 

uo.cast("Magic Arrow","Amigo3") 

endsub 

# >> SOLTAR MAGIA WALL OF STONE NO ULTIMO TARGET 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Magia_WS_LT() 

uo.deletejournal() 
uo.cast("Wall of Stone","laststatus") 
while not uo.injournal('In Sanct Ylem') and not uo.injournal('Targeting 
cancelled') and not uo.injournal('line of sight') 
wait(100) 
wend 
if uo.injournal('Targeting canceled') or uo.injournal('line of sight') then 
uo.print("MAGIA CANCELADA") 
else 
wait(300) 
uo.print("Faltam 2 Segundos") 
wait(1000) 
uo.print("Faltam 1 Segundo") 
wait(1000) 
uo.print("CONCLUIDO!") 
end if 

endsub 

# >> SOLTAR MAGIA PARALYZE FIELD NO ULTIMO TARGET 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Magia_PF_LT() 

uo.deletejournal() 
uo.cast("Paralyze Field","laststatus") 
while not uo.injournal('In Ex Grav') and not uo.injournal('Targeting 
cancelled') and not uo.injournal('line of sight') 
wait(100) 
wend 
if uo.injournal('Targeting canceled') or uo.injournal('line of sight') then 
uo.print("MAGIA CANCELADA") 
else 
wait(200) 
uo.print("Faltam 4 Segundos") 
wait(1000) 
uo.print("Faltam 3 Segundos") 
wait(1000) 
uo.print("Faltam 2 Segundos") 
wait(1000) 
uo.print("Faltam 1 Segundo") 
wait(1000) 
uo.print("CONCLUIDO!") 
end if 

endsub 



# >> CHEATS E UTILITARIOS  
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 


sub t() ; em testes (modifique a magia no cast) + para alto - baixo 
UO.WaitTargetTile("100",str(uo.getx("self")),str(uo.gety("self")),str(uo.getz("self")+5)) 
UO.Cast("Wall of Stone") 
wait(50) 
end sub 

sub Ress() 
UO.usetype("0x0e21") 
uo.waittargetground('0x2006') 
end if 
end sub 

sub Cortar() 
UO.usetype("0x1400") 
uo.waittargetground('0x2006') 
wait(100) 
uo.usetype("0x0F51") 
uo.waittargetground('0x2006') 
end sub 


# >> CORTAR CORPO E LUTEAR DO CHAO 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Loot_Chao() 

uo.waittargetground('0x2006') 
UO.Exec("usetype 0x0F51") 
wait(500) 
var i,n 
Dim R[1] 
R[1] = 'AL1' ;item 1 
R[1] = 'AL2' ;item 2 
R[1] = 'AL3' ;item 3 
R[1] = 'AL4' ;item 4 
R[1] = 'AL5' ;item 5 
R[1] = 'AL6' ;item 6 
R[1] = 'AL7' ;item 7 
R[1] = 'AL8' ;item 8 
R[1] = 'AL9' ;item 9 
R[1] = 'AL10' ;item 10 
R[1] = 'AL11' ;item 11 
R[1] = 'AL12' ;item 12 
i = 150 
FOR n=1 TO 1 
UO.FindType(R[n],-1,'ground') 
if uo.findcount() > 0 then 
UO.grab(0,"finditem") 
Wait(1000) 
end if 
NEXT 

end sub 

# =========================== 
# Macros de Fields 
# =========================== 

sub Wall() ; Solta Wall of Stone em / 
UO.Set('lasttarget','laststatus') 
uo.waittargettile("400",str(uo.getx("lasttarget")),str(uo.gety("lasttarget")),str(uo.getz("lasttarget"))) 
uo.cast("Wall of Stone") 
end sub 

sub Wall2() ; Fecha Wall of Stone em \ 
UO.Set('lasttarget','laststatus') 
uo.waittargettile("400",str(uo.getx("lasttarget")+1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
uo.cast("Wall of Stone") 
end sub 

sub Wall3() ; soltar wall em \ atraz do kra 
UO.Set('lasttarget','laststatus') 
uo.waittargettile("400",str(uo.getx("lasttarget")),str(uo.gety("lasttarget")-1),str(uo.getz("lasttarget"))) 
uo.cast("Wall of Stone") 
end sub 

sub Wall4() ; soltar wall em / atraz do kra 
UO.Set('lasttarget','laststatus') 
uo.waittargettile("400",str(uo.getx("lasttarget")-1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget"))) 
uo.cast("Wall of Stone") 
end sub 

sub fire() ; Solta Fire Field em \ 
UO.Set('lasttarget','laststatus') 
uo.waittargettile("400",str(uo.getx("lasttarget")+1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
uo.cast("Fire Field") 
end sub 

sub fire2() ; Solta Fire Field em / 
UO.Set('lasttarget','laststatus') 
Uo.waittargettile("400",str(Uo.getx("lasttarget")),str(Uo.gety("lasttarget")),str(Uo.getz("lasttarget"))) 
uo.cast("Fire Field") 
end sub 

sub pf() ; Solta Paralyse Field em / 
Uo.waittargettile("400",str(Uo.getx("lasttarget")),str(Uo.gety("lasttarget")),str(Uo.getz("lasttarget"))) 
Uo.cast("Paralyze Field") 
end sub 

sub pf2() ; Solta Paralyse Field em \ 
uo.waittargettile("400",str(uo.getx("lasttarget")+1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
Uo.cast("Paralyze Field") 
end sub 

sub wallfire2() ; Fecha o Player em X e Casta Fire Field. Favor rever os Delays nas linhas wait(4000) 
UO.Set('lasttarget','laststatus') 
uo.waittargettile("400",str(uo.getx("lasttarget")),str(uo.gety("lasttarget")),str(uo.getz("lasttarget"))) 
uo.cast("Wall of Stone") 
wait(3000) 
uo.waittargettile("400",str(uo.getx("lasttarget")+1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
uo.cast("Wall of Stone") 
wait(3000) 
uo.waittargettile("400",str(uo.getx("lasttarget")+1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
uo.cast("Fire Field") 
end sub 


sub wallfire() ; Fecha o Player em X e Casta Fire Field. Favor rever os Delays nas linhas wait(4000) 
UO.Set('lasttarget','laststatus') 
uo.waittargettile("400",str(uo.getx("lasttarget")),str(uo.gety("lasttarget")),str(uo.getz("lasttarget"))) 
uo.cast("Wall of Stone") 
wait(4500) 
uo.waittargettile("400",str(uo.getx("lasttarget")+1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
uo.cast("Wall of Stone") 
wait(4500) 
uo.waittargettile("400",str(uo.getx("lasttarget")+1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
uo.cast("Fire Field") 
end sub 

# ====================== # 
# MACROS DE FUGA # 
# ====================== # 


# >> TOMAR POÇÃO DE INVISIBILITY E RECALLAR 
# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

sub Recall_Invis() 

uo.exec("recall RuneFuga 2") 
uo.warmode(0) 
wait(250) 
uo.usetype("0x0F0E","0x011B") 
uo.Print('Recalando, NAO SE MECHA.') 
uo.Print('Recalando, NAO SE MECHA.') 
uo.Print('Recalando, NAO SE MECHA.') 

end sub 

# >> FICAR HIDE E RECALLAR 
# >>>>>>>>>>>>>>>>>>>>>>>>> 

sub Recall_Hide() 

uo.warmode(0) 
uo.Useskill('Hiding') 
uo.Print('Faltam 2 Segundos') 
wait(800) 
wait(800) 
uo.exec("recall RuneFuga 2") 
uo.Print('Recalando, NAO CORRA.') 
uo.Print('Recalando, NAO CORRA.') 
uo.Print('Recalando, NAO CORRA.') 

end sub 

sub healpassive() ; Funcao q permite que você se heale, ao perder life, Usa-se Bandagens 
while NOT UO.Dead() 
repeat 
if UO.Life < UO.str then 
UO.Exec("usetype 0x0E21") 
uo.waittargetself()
#UO.bandageself() 
wait(4000) 
endif 
until UO.Life == UO.str 
wend 
end sub 


# >> ARROW NA EXPLOSION - DMN 


sub Arrow_Explodmn() 

uo.waittargettype("0x0F0E","0x001E") 
uo.cast("Magic Arrow") 

end sub

#------------INICIO-------------
sub miningVip(); By ChavinhO (para Mina VIP DMS)
var t,x,y,dir,px,py
uo.msg('bank')
UO.AddObject ('CONTAINER')
While UO.Targeting()
   Wait(100)
Wend
inicio:
uo.usetype('0x103B')
t=3 #Quantos tiles seu char vai andar depois que minerar tudo a sua volta.
ChecarLimite(1831,6) #Limite X ou Y da Mina. #Quantos tiles seu char vai andar pra voltar depois de ultrapassar do limite.
IF (uo.weight >= 400) then #Peso maximo antes de comecar a guardar os Ores no Bank.
   ChecarLimite(1820,26)
   GuardarOres()
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
                 wait(200)
          until UO.InJournal("Voce pos|Tente miner|Voce nao|Nao ha|You cann|O alvo|target canc")
          if not UO.InJournal("Tente minerar|Nao ha|uma linha|You cannot") then
                 goto denovo
          endif
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

sub miningMinoc(); By ChavinhO (para Mina VIP DMS)
var t,x,y,dir,px,py
uo.msg('bank')
UO.AddObject ('CONTAINER')
While UO.Targeting()
   Wait(100)
Wend
inicio:
uo.usetype('0x103B')
t=3 #Quantos tiles seu char vai andar depois que minerar tudo a sua volta.
ChecarLimiteMinoc(488,18) #Limite X ou Y da Mina. #Quantos tiles seu char vai andar pra voltar depois de ultrapassar do limite.
uo.exec('useskill Hiding')
Wait(3800)
IF (uo.weight >= 100) then #Peso maximo antes de comecar a guardar os Ores no Bank.
   GuardarOres()
endif
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
                 wait(200)
          until UO.InJournal("Voce pos|Tente miner|Voce nao|Nao ha|You cann|O alvo|target canc")
          if not UO.InJournal("Tente minerar|Nao ha|uma linha|You cannot") then
                 goto denovo
          endif
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
 

sub GuardarOresComTarget()
var n
uo.msg('bank')
UO.AddObject ('CONTAINER')
While UO.Targeting()
   Wait(100)
Wend
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
#------------FIM-------------

##########################
#####FUNCAO PRINCIPAL#####
##########################
sub FullBook()
uo.charprint('0x0003','Iniciando Macro')
uo.charprint('0x0003','Fazer FullBook')
wait(1000)
lag()
fzScroll()
uo.charprint('0x0003','Fazendo Book de Spells')
wait(1000)
lag()
fzBook()
uo.charprint('0x0003','Guardando os Scrolls')
wait(1000)
lag()
porScroll()
uo.charprint('0x0003','Obrigado por ultilizar o macro')
uo.charprint('0x0003','Finalizando!')
endsub

######################################
#####FUNCAO PARA FAZER OS SCROLLS#####
######################################
Sub fzScroll()
var i, k, sair = 0
DIM nomes[8]
nomes[1] = "Reactive Armor Scr"
nomes[2] = "Agility Scroll"
nomes[3] = "Bless Scroll"
nomes[4] = "Archcure Scroll"
nomes[5] = "Blade Spirits Scro"
nomes[6] = "Dispel Scroll"
nomes[7] = "Chain Lightning Sc"
nomes[8] = "Earthquake Scroll"

uo.usetype('0x0FBF')
repeat
        wait(100)
until uo.lastgump( 'replyed' ) == 0 and uo.lastgump( 'text', 4 ) == 'Primeiro Circulo'
for i = 1 to 8
                uo.charprint('0x0026',''+str(i)+'º Circulo')
        uo.lclick(68,i*20+98)
                repeat
                        wait(100)
                until uo.lastgump( 'replyed' ) == 0 and uo.lastgump( 'text', 14 ) == nomes[i]
        for k = 1 to 8
                uo.deletejournal()
                sair = 0
                if i == 1 and k == 3 then
                        k = 4
                        uo.charprint('0x0026','Pulando Spell Desabilitada')
                endif
                if i == 4 and k == 3 then
                        k = 4
                        uo.charprint('0x0026','Pulando Spell Desabilitada')
                endif
                if i == 5 and k == 3 then
                        k = 4
                        uo.charprint('0x0026','Pulando Spell Desabilitada')
                endif
                if i == 7 and k == 8 then
                                                sair = 81
                                                uo.charprint('0x0026','Pulando Spell Desabilitada')
                endif
                uo.lclick(235,k*20+98)
                repeat
                        wait(100)
                until uo.injournal('Voce pos|Voce falhou') or sair > 80
                if uo.injournal('Voce falhou') then
                        k = k - 1
                endif
        next
next
end sub
####################################
#####FUNCAO PARA FAZER O BOOK#######
####################################
Sub fullBook()
repeat
        uo.deletejournal()
        uo.lclick(72,277)
        repeat
                wait(100)
        until uo.lastgump( 'replyed' ) == 0 and uo.lastgump( 'text', 14 ) == "spellbook"
        uo.lclick(234,113)
        repeat
                wait(100)
        until uo.injournal('Voce pos|Voce falhou|Skill I')
until NOT uo.injournal('Voce falhou|Skill I')

repeat
        uo.findtype('0x0EFA','-1','backpack')   
        uo.click('finditem')
        lag()
        if uo.injournal('0 spells') then
                uo.addobject('book','finditem')
                uo.charprint('0x0026','Object Book Adicionado')
        else
                uo.ignore('finditem')
        endif
until uo.injournal('0 spells')
endsub
########################################
#####FUNCAO PARA GUARDAR OS SCROLLS#####
########################################
Sub porScroll()
var i
DIM scroll[60]

scroll[1] = "0x1F2D" #reactve ar
scroll[2] = "0x1F2E" #clumsy
scroll[3] = "0x1F30" #fleeblemind
scroll[4] = "0x1F31" #heal
scroll[5] = "0x1F32" #ma
scroll[6] = "0x1F33" #night sight
scroll[7] = "0x1F34" #weaken
scroll[8] = "0x1F35" #agility
scroll[9] = "0x1F36" #cunning
scroll[10] = "0x1F37" #cure
scroll[11] = "0x1F38" #harm
scroll[12] = "0x1F39" #magictrap
scroll[13] = "0x1F3A" #magicuntrap
scroll[14] = "0x1F3B" #protection
scroll[15] = "0x1F3C" #strength
scroll[16] = "0x1F3D" #bless
scroll[17] = "0x1F3E" #fireball
scroll[18] = "0x1F3F" #magiclock
scroll[19] = "0x1F40" #poison
scroll[20] = "0x1F41" #telesinese
scroll[21] = "0x1F42" #teleport
scroll[22] = "0x1F43" #unlock
scroll[23] = "0x1F44" #wall of stone
scroll[24] = "0x1F45" #archcure
scroll[25] = "0x1F46" #archprot
scroll[26] = "0x1F48" #firefield
scroll[27] = "0x1F49" #great heal
scroll[28] = "0x1F4A" #lighting
scroll[29] = "0x1F4B" #manadrain
scroll[30] = "0x1F4C" #recall
scroll[31] = "0x1F4D" #blade spirit
scroll[32] = "0x1F4E" #dispel field
scroll[33] = "0x1F50" #magic reflection
scroll[34] = "0x1F51" #mind blast
scroll[35] = "0x1F52" #paralize
scroll[36] = "0x1F53" #poison field
scroll[37] = "0x1F54" #summon creature
scroll[38] = "0x1F55" #dispel
scroll[39] = "0x1F56" #eb
scroll[40] = "0x1F57" #explosion
scroll[41] = "0x1F58" #invisibility
scroll[42] = "0x1F59" #mark
scroll[43] = "0x1F5A" #masscurse
scroll[44] = "0x1F5B" #pf
scroll[45] = "0x1F5C" #reveal
scroll[46] = "0x1F5D" #chain light
scroll[47] = "0x1F5E" #energy field
scroll[48] = "0x1F5F" #fs
scroll[49] = "0x1F60" #gate
scroll[50] = "0x1F61" #manavampire
scroll[51] = "0x1F62" #massdispel
scroll[52] = "0x1F63" #meteorstorm
scroll[53] = "0x1F65" #earthquake
scroll[54] = "0x1F66" #energy vortex
scroll[55] = "0x1F67" #ressurection
scroll[56] = "0x1F68" #summon air
scroll[57] = "0x1F69" #summon daemon
scroll[58] = "0x1F6A" #summon earth
scroll[59] = "0x1F6B" #summon fire
scroll[60] = "0x1F6C" #summon water

for i = 1 to 60
        uo.findtype(scroll[i],'-1,','backpack')
        if uo.findcount() > 0 then
                repeat
                uo.moveitem('finditem','-1','book')
                wait(500)
            until NOT uo.count(scroll[i]) == 1
        endif
next
end sub
#####################################
#####FUNCAO PARA VERIFICAR O LAG#####
#####################################
Sub lag()
uo.deletejournal()
uo.click('backpack')
repeat
wait(1)
until uo.injournal('backpack')
end sub

sub configArvores()
    var f=file('arvores.dat')
    var w,n=0,i

    dim aX[300]
    dim aY[300]
    dim aID[300]

    uo.exec('filterspeech add party')
    uo.exec('filterspeech on')
    uo.say('')

    uo.charprint('0x0045','Best Lumber (by ChavinhO)')
    uo.charprint('0x0035','Escolha as arvores...')
    uo.charprint('0x0022','Selecione seu char para finalizar')

    loop:
        uo.say('/add')
        while not uo.targeting()
            wait(10)
        wend
        while uo.targeting()
            wait(10)
        wend

        if uo.lasttile(0)==400 then
            if n>0 then
                f.open()
                f.create()
                w=safe call f.writeln(str(n))
                for i=1 to n
                    w=safe call f.writeln(str(aX[i])+' '+str(aY[i])+' '+str(aID[i]))
                next
                f.close()
            endif
            goto fim
        endif

        if aID(str(uo.lasttile(0)))==0 then
            uo.charprint('0x0022','Arvore invalida.')
            goto loop
        endif

        if n>=1 then
            for i=1 to n
                if str(aX[i])+' '+str(aY[i]) == str(uo.lasttile(1))+' '+str(uo.lasttile(2)) then
                    uo.charprint('0x0022','Arvore repetida.')
                    goto loop
                endif
            next
        endif

        n=n+1
        aID[n] = uo.lasttile(0)
        aX[n] = uo.lasttile(1)
        aY[n] = uo.lasttile(2)
        uo.charprint('0x0045','Arvore adicionada('+str(n)+')')
    goto loop
    fim:
    if n>0 then
        uo.charprint('0x0045','Avores salvas: '+str(n))
        uo.charprint('0x0045','Pronto! arrume as runas e inicie o macro!')
        if n<76 then
            uo.charprint('0x0022','Recomendado mais de 75 arvores.')
        endif
    else
        uo.charprint('0x0022','Arquivo nao modificado/criado.')
    endif
    uo.exec('filterspeech clear')
    uo.exec('filterspeech off')
end sub

Sub aID( type )
var i
DIM tree[23]
tree[0] = '3274'
tree[1] = '3275'
tree[2] = '3276'
tree[3] = '3277'
tree[4] = '3280'
tree[5] = '3283'
tree[6] = '3286'
tree[7] = '3288'
tree[8] = '3289'
tree[9] = '3290'
tree[10] = '3291'
tree[11] = '3292'
tree[12] = '3293'
tree[13] = '3294'
tree[14] = '3295'
tree[15] = '3296'
tree[16] = '3299'
tree[17] = '3302'
tree[18] = '3394'
tree[19] = '3395'
tree[20] = '3417'
tree[21] = '3440'
tree[22] = '3461'
for i = 0 to 22
if tree[i]==type then
return 1
endif
next
return 0
endsub

#------------------FIM FUNÇÕES DE CONFIGURAÇÃO DAS ARVORES-----------------

#------------------INICIO COMENTARIOS-----------------
# GRAVE O ARQUIVO DA LOCALIZACAO DAS ARVORES COM A FUNÇÂO ACIMA
# O ARQUIVO É GRAVADO NA PASTA DO UO COM NOME DE "arvores.dat"
# O SISTEMA DE ANDAR É MUITO EFICIENTE MAS NÃO FAZ MÁGICAS
# USE ARVORES EM LUGAR ABERTO E POUCOS BLOCKS EXTENSOS
# GRAVE UMA RUNA AO LADO DA PRIMEIRA ARVORE, E COLOQUE NO RUNEBOOK
# TEM PROTEÇÃO CONTRA PKILLERS (GUARDS, BANDS, POTS, CURE)
# POR ISSO COLOQUE BANDS E POTS NA BAG
# COLOQUE UMA RUNA EM BRANCO NA SUA BAG QUE AJUDARÁ NO MACRO...
# ...VOLTANDO AO LUGAR EXATO ONDE ESTAVA ANTES DE OCUPAR TODO PESO
# QUANDO O CHAR IR AO BANK UMA CAIXA DE TEXTO MOSTRA TODOS SEUS LOGS
# PARA VER STATUS(LOGS, ARVORES, IDAS AO BANK) CLIQUE NO SEU CHAR
# PARA VER TODOS LOGS DA SUA BAG CLIQUE NA SUA BACKPACK CHAR
# CASO VOCE NÃO É GM, APARECE NOS STATUS SUA SKILL TAMBÉM
# OS LOGS TOTAIS (SUA BAG+BANK) SÃO MOSTRADOS SÓ APÓS A PRIMEIRA IDA AO BANK
# CONFIGURE ABAIXO E DEPOIS É SÓ INICIAR A MACRO
# AS CONFIGURAÇÕES ABAIXO JA ESTÃO FUNCIONANDO PARA O DMSSHARD.COM.BR
#                                                                                                         by CHAVINHO ALLIANCE
#------------------FIM COMENTÁRIOS-----------------

#------------------INICIO MACRO LUMBER-----------------

    #--------------------INICIO CONFIG--------------------
    var f=file('arvores.dat')                         #NOME arquivo que você gravou as informações das arvores.
    var longe='Isto esta'                             #MSGs (quando nao alcança a arvore)
    var pegou='Voce pos'                         #MSGs (quando pega logs)
    var acabou='Nao ha ma'                     #MSGs (quando acabaram os logs)
    var falha='Voce nao con|Skills L'         #MSGs (quando falhou)
    var ataque='Vortex|te atacando'          #MSGs (quando ha perigo)
    var bank='Voce tem'                           #MSG (quando abre o Banco)
    var potheal='.drinkheal'                        #MSGs de macro de tomar poção do seu shard(se o shard não tem use ',useobject X' ',usetype X' etc..)
    var tent1=4                                         #TENTATIVAS de pegar o log antes de ir para outra arvore
    var tent2=4                                         #TENTATIVAS EXTRAS caso char ja ter pego log na arvore naquele momento
                                                               #(ACIMA, proteção caso nao eh GM lumber, char pode ficar na mesma arvore para sempre)
    var peso=350                                     #PESO para ir guardar os logs
    var runebank='runebook 4'                 #RUNEBOOK e NUMERO da runa do bank
    var runelogs='runebook 5'                   #RUNEBOOK e NUMERO da runa para a primeira arvore
    var colorm = 44                                   #COR DO TEXTO de informação dos logs
                                                              #Ponha 1 para colorido de acordo com a cor do log, ou a cor desejada para todos
    #--------------------FIM CONFIG--------------------

sub lumber()

    dim aID[500]
    dim aX[500]
    dim aY[500]
    var a, i, try, log

    starting()

    f.open()
    a=safe call f.readNumber()
    for i=1 to a
        aX[i]=safe call f.ReadNumber()
        aY[i]=safe call f.ReadNumber()
        aID[i]=safe call f.ReadNumber()
    next
    f.close()

    loop:
        for i=1 to a
            if ( uo.weight > peso ) then
                uo.charprint('0x0022','Voce atingiu o limite de peso')
                guardar.logs()
            endif
            log=0
            try=0
            irarvore(aX[i],aY[i])
            uo.charprint('0x0050','Arvore: '+str(i)+' ('+str(a)+')')
            repeat
                uo.deletejournal()
                uo.waittargettile(aID[i], aX[i], aY[i], 0)
                uo.useobject('hatchet')
                repeat
                    wait(10)
                    status()
                until uo.injournal( longe + '|' + pegou + '|' + acabou + '|' + ataque + '|' + falha ) or uo.life<uo.str
                if uo.injournal( pegou ) then
                    msg.log()
                    log=1
                endif
                if uo.injournal( falha ) then
                    try=try+1
                    uo.charprint('0x0007', 'Tentativa: ' + str(try) + '/' + str(log*tent1+tent2) )
                endif
                if uo.life<uo.str or uo.injournal( ataque ) then
                    perigo()
                endif
            until uo.injournal( longe + '|' + acabou ) or (try==tent1 and log==0) or try==tent1+tent2
             if log==1 then
                uo.setglobal('arvores',val(uo.getglobal('arvores'))+1)
            endif
        next
        recall('recall '+runelogs)
    goto loop
end sub

sub status()
    var x, l,uid,n=uo.getname('self')
    if uo.injournal(n) then
        uo.deletejournal(n)
        uo.findtype('0x1BDD','0x0000','backpack')
        x=uo.getquantity('finditem')+val(uo.getglobal('logs'))
        uo.charprint('0x0047','..foi ao banco '+str(val(uo.getglobal('bank')))+' vezes.')
        uo.charprint('0x0047','..cortou '+str(val(uo.getglobal('arvores')))+' arvores.')
        uo.charprint('0x0047','..tem '+str(x)+' logs normais.')
        if uo.skillval('Lumberjacking',1) < 1000 then
            uo.print('Voce esta com '+ str(uo.skillval('Lumberjacking',1)) + ' de LumberJacking.')
        endif
    endif
    if uo.injournal('backpack') then
        uid=uo.getserial('backpack')
        showlogs(uid)
        uo.deletejournal('backpack')
    endif
endsub

sub starting()
    uo.setglobal('arvores','')
    uo.setglobal('bank','')
    uo.setglobal('logs','')
    hatchet()
    uo.charprint('0x0007','Iniciando macro.')
    uo.charprint('0x0045','By ChavinhO!')
    recall('recall '+runelogs)
    uo.deletejournal()
endsub

sub msg.log()
    var l, c, n
    uo.ignorereset()
    uo.deletejournal('logs')
    uo.findtype('0x1BDD','-1','backpack')
    l=uo.findcount('finditem')-1
    while l>0
        uo.ignore('finditem')
        uo.findtype('0x1BDD','-1','backpack')
        l=l-1
    wend
    uo.findtype('0x1BDD','-1','backpack')
    uo.click('finditem')
    repeat
        wait(1)
    until uo.injournal('log')
    c=uo.getcolor('finditem')
    if colorm<>1 then
        c=colorm
    endif
    n=uo.getname('finditem')
    uo.charprint( c,'Voce tem: '+n )
    uo.ignorereset()
endsub

sub logs.bank()
    var b,c,n
    uo.deletejournal()
    uo.charprint('0x0022','Guardando logs')
    uo.msg('bank')
    repeat
        wait(5)
    until uo.injournal( bank )
    b=uo.getserial('lastcontainer')
    while uo.count('0x1BDD')>0
        uo.findtype('0x1BDD','-1','backpack')
        while not uo.ContainerOF('finditem')==b
            UO.moveitem('finditem','-1',b)
            wait(5)
        wend
        if uo.getcolor('finditem')=='0x0000' then
            uo.setglobal('logs',val(uo.getglobal('logs'))+uo.getquantity('finditem'))
        endif
    wend
    showlogs(b)
endsub

sub showlogs(uid)
    var l,n
    if not uid==uo.getserial('backpack') then
        uo.exec('textclear')
    endif
    uo.ignorereset()
    uo.deletejournal('logs')
    uo.findtype('0x1BDD','-1',uid)
    l=uo.findcount('finditem')
    while l>0
        uo.deletejournal('logs')
        uo.click('finditem')
        repeat
            wait(1)
        until uo.injournal('log')
        n=uo.getname('finditem')
        uo.print('Voce tem: '+n)
        if uid==uo.getserial('backpack') then
            uo.exec('showjournal 1')
        endif
        uo.ignore('finditem')
        uo.findtype('0x1BDD','-1',uid)
        l=l-1
    wend
    uo.ignorereset()
endsub

sub guardar.logs()
    if  uo.count('0x1F14') then
        uo.findtype('0x1F14','-1','backpack')
        uo.cast('Mark','finditem')
        wait(4500)
    endif

    recall('recall '+runebank)
    uo.setglobal('bank',val(uo.getglobal('bank'))+1)

    logs.bank()

    if uo.count('0x1F14') then
        uo.findtype('0x1F14','-1','backpack')
        recall('runa')
    else
        recall('recall '+runelogs)
    endif
endsub

sub recall(runa)
    var px=uo.getx('self'),py=uo.gety('self'),timer
    timer=uo.timer() + 80
    if runa=='runa' then
        uo.cast('Recall','finditem')
    else
        uo.exec(runa)
    endif
    while px==uo.getx('self') and py==uo.gety('self')
        if uo.timer() >= timer then
            uo.useskill('Meditation')
            recall(runa)
        endif
        wait(5)
    wend
endsub

sub irarvore(x,y)
    dim key[8]
    key[0] = '383933'
    key[1] = '383739'
    key[2] = '394034'
    key[3] = '373840'
    key[4] = '403735'
    key[5] = '403937'
    key[6] = '373836'
    key[7] = '394038'
    var myX,myY,t=0,d,d2,z,m=0,mydir
    repeat
        myX=uo.getX();
        myY=uo.getY();
        if x==myX then
            if y>myY then
                uo.Press(35)
            endif
            if y<myY then
                uo.Press(33)
            endif
        else
            if x<myX then
                if y==myY then
                    uo.Press(36)
                else
                    if y<myY then
                        uo.Press(38)
                    endif
                    if y>myY then
                        uo.Press(37)
                    endif
                endif
        endif
            if x>myX then
                if y==myY then
                    uo.Press(34)
                else
                    if y<myY then
                        uo.Press(39)
                    endif
                    if y>myY then
                        uo.Press(40)
                    endif
                endif
            endif
        endif
        if uo.getx()==myX and uo.gety()==myY then
            if t==4 then
                t=0
                mydir=uo.getdir()
                d=val(MID(key[mydir],0,2))
                d2=val(MID(key[mydir],2,2))
                for z=1 to 4
                    uo.press(d)
                next
                if uo.getx()==myX and uo.gety()==myY then
                    for z=1 to 3
                        uo.press(d2)
                    next
                endif
            else
                t=t+1
            endif
        endif
        wait(70)
    until (Num(x-uo.getx())<=1 and Num(y-uo.gety())<=2) or (Num(x-uo.getx())<=2 and Num(y-uo.gety())<=1)
end sub

sub Num(num)
    if num>=0 then
        return num
    else
        return num*(-1)
    end if
end sub

sub perigo()
    var t1=0,t2=0,t3=0,t4=0
    repeat
        if t1 < uo.timer() then
            uo.msg('guards')
            t1=UO.Timer() + 10
        endif
        if uo.poisoned('self') then
            if t2 < uo.timer() then
                uo.cast('Cure','self')
                t2=UO.Timer() + 30
                wait(100)
        endif
    else
        if t3< uo.timer() then
            uo.bandageself()
            wait(120)
            timer3=UO.Timer() + 65
        endif
    endif
    if uo.life < 75 then
        if t4 < uo.timer() then
            uo.say( potheal )
            t4=UO.Timer() + 160
            wait(100)
        endif
    endif
    wait(20)
until uo.life>=uo.str
uo.exec('exec guards')
end sub

sub guards()
    var i
        for i=1 to 6
            uo.msg('guards')
            wait(1000)
        next
endsub

sub hatchet()
    uo.useobject('backpack')
    if uo.count('0x0F44') or uo.count('0x0F43') then
        if uo.count('0x0F44') then
            uo.findtype('0x0F44','-1','my')
        endif
        if uo.count('0x0F43') then
            uo.findtype('0x0F43','-1','my')
        endif
        uo.addobject('hatchet','finditem')
    else
        uo.charprint('0x0022','Voce nao tem nenhum Hatchet')
        uo.charprint('0x0022','Macro parado')
        uo.exec('terminate all')
    endif
endsub

#------------------FIM     MACRO LUMBER-----------------