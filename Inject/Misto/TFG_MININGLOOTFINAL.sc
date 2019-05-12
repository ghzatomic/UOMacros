

sub miningMinoc(); By GHZATOMIC (para Mina TfG)
   ;IrAteMinaMinoc()
   var t,x,y,dir,px,py
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
   #uo.msg('bank')
   #UO.AddObject ('CONTAINER')
   #While UO.Targeting()
   #   Wait(100)
   #Wend
   inicio:
   #uo.usetype('0x103B')
   t=3 #Quantos tiles seu char vai andar depois que minerar tudo a sua volta.
   ChecarLimiteMinoc(488,18) #Limite X ou Y da Mina. #Quantos tiles seu char vai andar pra voltar depois de ultrapassar do limite.
   ;uo.UseSkill('Detect Hidden')
   ; Wait(2800)
   ;uo.exec('useskill Hiding')
   ;Wait(3800)
   IF (uo.weight >= 340) then #Peso maximo antes de comecar a guardar os Ores no Bank.
      uo.print("Indo para o bank")
      IrAteBankMinoc()
      GuardarOres()
      IrAteMinaMinoc()
      uo.usetype('0x0E85')
   endif
   
   if UO.InJournal("You see: Energy Vortex|Energy Vortex") then
      uo.msg('guards all release guards !!!')
   end if 
   
   if UO.Life < UO.str then 
      uo.msg('guards all release guards !!!')
      UO.bandageself() 
      wait(4000)
   endif
   for x = -2 to 2
      for y = -2 to 2
         denovo:
         wait(500) 
         ;Pegar coisas do chao
         ; var i,n 
         
         ; i = 150 
         ;FOR n=1 TO 1 
         ;   UO.FindType(R[n],-1,'ground') 
         ;   if uo.findcount() > 0 then 
         ;      UO.grab(0,"finditem") 
         ;      Wait(1000) 
         ;   end if 
         ;NEXT 
         UO.DeleteJournal()
         if UO.InJournal("You see: Energy Vortex|Energy Vortex") then
            uo.msg('guards all release guards !!!')
         end if 
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
         if UO.InJournal("You see: Energy Vortex|Energy Vortex") then
            uo.msg('guards all release guards !!!')
         end if 
         if not UO.InJournal("You cannot") then
            goto denovo
         endif
         UO.print("Tentando novamente ...")
         uo.usetype('0x0E85')
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
   
   uo.info()
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
   localRecall()
   uo.press(33);
   uo.press(33);
   uo.press(33);
   uo.press(33);
   uo.press(40);
   uo.press(40);
   uo.press(40);
   uo.press(34);
   uo.press(34);
   uo.press(34);
   uo.press(34);
   uo.press(35);
   uo.press(35);
   uo.press(35);
   uo.press(35);
   uo.press(40);
   uo.press(40);
   uo.press(40);
   uo.press(34);
   uo.press(34);
   uo.press(34);
   uo.press(34);
   uo.press(35);
   uo.press(35);
   uo.press(35);
   uo.press(35);
   uo.say(".recall 1 14")
   wait(7000)
end sub

sub IrAteMinaMinoc()
   
   uo.say(".recall 1 11")
   wait(7000)
   uo.press(38);
   uo.press(38);
   uo.press(38);
   uo.press(38);
   uo.press(39);uo.press(38);
   uo.press(39);
   uo.press(39);
   uo.press(39);
   uo.press(39);
   uo.press(39);
   uo.press(39);
   uo.press(39);
   uo.press(39);
   uo.press(39);
   uo.press(39);
   uo.press(39);
   uo.press(38);
   uo.press(38);
   uo.press(39);
   uo.press(39);
   uo.press(38);
   uo.press(39);
   uo.press(38);
   uo.press(39);
end sub

sub GuardarOres()
   var n
   DIM ID[12]
   ID[1]='0x19B9'
   ID[2]='0x19B8'
   ID[3]='0x19BA'
   ID[4]='0x19B7'
   ID[5] = '0x0F16 USMXKMD'; amesthysts
   ID[6] = '0x0F10 USMXKMD'; emerald
   ID[7] = '0x0F0F USMXKMD'; star sapphire
   ID[8] = '0x0F18 USMXKMD'; tourmaline
   ID[9] = '0x0F26 USMXKMD'; diamond
   ID[10] = '0x0F11 USMXKMD'; sapphire
   ID[11] = '0x0F15 USMXKMD'; citrine
   ID[12] = '0x0F13 USMXKMD'; rubi
   
   uo.msg('banker bank')
   wait(1000)
   uo.useobject('UVDFKMD')
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
         UO.FindType(ID[n],'-1')
         uo.moveitem('finditem', '0', 'UVDFKMD')
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

sub getLastContainer()
   uo.print(uo.getserial('lastcontainer'))
end sub

sub localRecall()
   Caminhar(2557,500,0)
end sub

Sub Caminhar(x,y,dist)
   var c=0
   var cx
   var cy
   var limite=3000
   var dir
   var loop
   Dim Anda[8]
   Anda[0]=33   ; N ;
   Anda[1]=39   ; NE ;
   Anda[2]=34   ; E ;
   Anda[3]=40   ; SE ;
   Anda[4]=35   ; S ;
   Anda[5]=37   ; SW ;
   Anda[6]=36   ; W ;
   Anda[7]=38   ; NW ;
   While (UO.GetX()>x+dist Or UO.GetX()<x-dist Or UO.GetY()>y+dist Or UO.GetY()<y-dist) And c<10 And limite>0
      cx=UO.GetX()
      cy=UO.GetY()
      If (UO.GetX()<=x+dist And UO.GetX()>=x-dist) And UO.GetY()>y+dist Then
         dir=0
      End If
      If UO.GetX()<x-dist And UO.GetY()>y+dist Then
         dir=1
      End If
      If UO.GetX()<x-dist And (UO.GetY()<=Y+dist And UO.GetY()>=Y-dist) Then
         dir=2
      End If
      If UO.GetX()<x-dist And UO.GetY()<y-dist Then
         dir=3
      End If
      If (UO.GetX()<=x+dist And UO.GetX()>=x-dist) And UO.GetY()<y-dist Then
         dir=4
      End If
      If UO.GetX()>x+dist And UO.GetY()<y-dist Then
         dir=5
      End If
      If UO.GetX()>x+dist And (UO.GetY()<=Y+dist And UO.GetY()>=Y-dist) Then
         dir=6
      End If
      If UO.GetX()>x+dist And UO.GetY()>y+dist Then
         dir=7
      End If
      If c<=5 Then
         UO.Press(Anda[dir])
         Wait(100)
      Else
         dir=UO.Random(8)
         For loop=0 to UO.Random(5)+2
            UO.Press(Anda[dir])
            Wait(100)
         Next
      End If
      If UO.GetX()==cx And UO.GetY()==cy Then
         c=c+1
      Else
         c=0
      End If
      limite=limite-1
   WEnd
End Sub

sub debug()     
   var cy=UO.GetY()
   uo.print(str(UO.GetX()))
   uo.print(str(cy))
end sub


sub healpassive() ; Funcao q permite que você se heale, ao perder life, Usa-se Bandagens 
   
   while NOT UO.Dead() 
      uo.deletejournal() 
      repeat 
         if UO.Life < UO.str then 
            #UO.Exec("usetype 0x0E21") 
            #uo.waittargetself()
            ;Armas1()
            UO.bandageself() 
            wait(4000) 
            ;Armas1()
            
         endif
         ;if UO.InJournal("You are frozen and can not move") then
         ;   desparaliza()
         ;   wait(2000)
         ;endif 
         ;if UO.InJournal("you feel nauseous") then
         ;uo.waittargettype('0x0F02','0x0000')
         ;curarse()
         ;wait(3000)
         ;endif 
      until UO.Life == UO.str    
      ;if UO.InJournal("You are frozen and can not move") then
      ;   desparaliza()
      ;   wait(2000)
      ;endif 
      ;if UO.InJournal("you feel nauseous") then
      ;uo.waittargettype('0x0F02','0x0000')
      ;curarse()
      ;wait(3000)
      ;endif 
      wait(100)
   wend 
end sub 