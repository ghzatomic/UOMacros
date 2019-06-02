var INIMIGO = 0;
var autobandage;
var  arma ;

sub autoload()
   uo.SetEasyUO(1,"0") ;usaarma
   ArmaSet()
   usaArma()
end sub


sub ArmaSet()
   uo.addobject('arma')
   while uo.targeting()
      wait(100)
   wend
   
   #uo.addobject('escudo')
   # while uo.targeting()
   #    wait(100)
   # wend
   
   # uo.addobject('bow')
   #while uo.targeting()
   #   wait(100)
   #wend
end sub



sub usaArma()
   var  objInimigoX =uo.getserial('INIMIGO') ;
   while not UO.Dead()
      if (uo.GetEasyUO(1) == "1")  then 
         arma = uo.getserial('arma');
         If Not UO.ObjAtLayer('Lhand') == arma Then
            uo.equip('Lhand',arma)
         end if
         objInimigoX =uo.getserial('INIMIGO')
         UO.Set('lasttarget',objInimigoX) 
         uo.attack( objInimigoX ) 
         wait(200)
      end if
   wend 
end sub

sub usaBomba();0x0E73
   ##//cast 'Magic Arrow' ; waittargettype 0x0F0E
   UO.UseObject('0x0E73') 
   
end sub

sub equip()           
   if (uo.GetEasyUO(1) == "0") then
      uo.SetEasyUO(1,"1")
   else
      arma = uo.getserial('arma');
      uo.equip('Lhand',arma)
      uo.SetEasyUO(1,"0") 
   end if
   UO.print(uo.GetEasyUO(1))
end sub



sub recall();0x0E73
   
   UO.say('.recall 1,1') 
   
end sub
sub bandage()
   if (autobandage == true) then  
      uo.print('off')
      autobandage = false;
   else
      uo.print('1')
      autobandage = true;
   end if
   
end sub

sub CureBandsHeal();CuraPoison
   uo.deletejournal();
   UO.AddObject ('arma')
   
   while NOT UO.Dead() 
      repeat 
         ;uo.deletejournal();
         desparaliza();
         verificaManaETomaPotionOuMedita() 
         uo.deletejournal();
         If UO.Poisoned() then
            verificaECuraPoison() ;
         else
            verificaHeal();
            wait(2500);
         end if
         wait(200);
      until UO.Life == UO.str 
   wend 
end Sub

sub main() 
   CureBandsHeal();
end sub

sub detectHidden()
   UO.useskill('Detect Hidden')
   wait(3000)
   uo.say("Guards")
   wait(300)
end sub
sub andaDaMinaAteORess()
   tentaSairDaMina()
   ChecarLimite(488,6)
   move2(36,6,30)
   uo.serverprint('X')
   move2(35,4,20)
   
end sub

sub tentaSairDaMina()
   while ((UO.GetX('self') >= 2558) and (UO.GetY('self') <= 489))
      move2(36,6,10)
      uo.serverprint('1')
      move2(35,4,20)
      uo.serverprint('2')
   wend
end sub 

sub CheckLag()
   
end sub


#north -- send_step(33,0)
#north east -- send_step(39,1)
#east -- send_step(34,2)
#south east -- send_step(40,3)
#south -- send_step(35,4)
#south west -- send_step(37,5)
#west -- send_step(36,6)
#north west -- send_step(38,7)
sub send_step(keycode,dir) 
   var x = UO.GetX() 
   var y = UO.GetY() 
   var timeout = 0 
   if UO.GetDir()<>dir then 
      UO.Press(keycode) 
      Repeat 
         wait(50) 
      Until UO.GetDir()==dir 
   endif 
   UO.Press(keycode) 
   Repeat 
      timeout=timeout+50 
      wait(50) 
   Until x<>UO.GetX() || y<>UO.GetY() || timeout>2000 
   if timeout>2000 then 
      return 0 
   endif 
   return 1 
end sub

#DONT CHANGE THIS FUNCTION
sub move(keycode,dir,numberOfTiles)
   var i = 0
   var x = UO.GetX()
   var y = UO.GetY()
   Repeat
      x = UO.GetX()
      y = UO.GetY()
      Repeat
         send_step(keycode,dir)
         CheckLag()
      Until x <> UO.GetX() || y <> UO.GetY()
      i = i + 1
   Until i == numberOfTiles
end sub


sub andaAleatorio()
   ; 36 - diag baixo esc
   ; 37 - diag baixo dir
   ; 38 - Diag cima esc
   ; 39 - Diag cima dir
   ; 33 - anda p cima
   ; 34 - anda p direita
   ; 35 - anda p baixo
   ; 32 - anda p esquerda
   var passos = UO.Random(8)+3
   var rand = UO.Random(5)+2
   anda(passos,rand)
   passos = UO.Random(8)+3
   rand = UO.Random(5)+2
   anda(passos,rand)
   uo.press(37)
   wait(100)
   uo.press(37)
   passos = UO.Random(8)+3  
   rand = UO.Random(5)+2
   anda(passos,rand)
   ChecarLimite(488,6)
end sub

sub chegasLimite()
   ChecarLimite(488,10);
end sub

sub detectaVerificaVidaEChamaGuards() ;
   uo.deletejournal()
   ChecarLimite(488,10);
   if UO.Life < UO.str then 
      detectHidden()
      UO.Cast('Heal','self')
      wait(1700)
      andaAleatorio()
   endif 
   if UO.InJournal("Grav|Flam|Por") then
      detectHidden()
      andaAleatorio()
      UO.cast("Mass Dispel")
   endif 
end sub


sub getlag() ; verifica o ping e imprimi numa fala do seu personagem
   var a=0
   uo.deletejournal()
   uo.click('backpack')
   repeat
      a=a+1
      wait(1)
   until uo.injournal('backpack')
   uo.serverprint('Ping: '+ STR(A*1) + ' ms')
end sub

Sub MountKill() ; antes de usar digite ',addobject horse' no seu UO e clique na montaria
   If UO.ObjAtLayer('Horse') Then
      UO.UseObject('self')
      UO.Msg('All kill')
      UO.Exec("waittargetlast") 
   Else
      UO.Msg('All Come')
      UO.UseObject('horse')
   End If
End Sub

Sub Mount() ; antes de usar digite ',addobject horse' no seu UO e clique na montaria
   If UO.ObjAtLayer('Horse') Then
      UO.UseObject('self')
      ;UO.Msg('All Stay')
      UO.Msg('All kill')
      uo.Msg(",waittargetlast")
   Else
      UO.Msg('All Come')
      UO.UseObject('horse')
   End If
End Sub

#----Inicio macros de mining----


sub tracking() ; Tracking
   uo.print('%autoload by SmaCk')
   uo.print('Tracking 1.0 DMS Shard')
   wait(2000)
   uo.print('Para esse macro funcionar corretamente esteja em um local longe de qualquer tipo de Monstro')
   wait(5000)
   While UO.SkillVal( 'Tracking' ) < 1028
      UO.CancelMenu() 
      UO.AutoMenu('Tracking','Monsters') 
      UO.useskill('Tracking')
      wait(2000)
   wend 
end sub


sub taste() ; Taste ID
   uo.print('%autoload by SmaCk')
   uo.print('Taste Identification 1.0 DMS Shard')
   While UO.SkillVal( 'Taste Identification' ) < 1058 
      UO.waittargettype('0x0EFA')
      UO.useskill('Taste Identification')
      wait(2500)
   wend
end sub

# ----------------------------------------------------------------------------

sub opendoor1()
   uo.say(".open_door")
end sub

sub bugaNego()
   var x=0
   If UO.Count('0x0F0E','0x01F7')>0 then
      ;UO.UseType('0x0F0E','0x01F7');
      ;UO.Cast('Invisibility','self')
      UO.useskill('Hiding')
      wait(3000)
      For x=1 to 40
         If UO.ObjAtLayer('Horse') Then
            UO.UseObject('self')
         Else
            UO.UseObject('pet')
         End If 
         wait(200)
      next
   end if
   
end sub

sub desparaliza2()
   
   
   uo.deletejournal();
   uo.waittargetobject('0x0F02')
   UO.Cast('Magic Arrow','0x0F02')
   
end sub

sub desparaliza()
   
   if UO.InJournal("Voce esta paralisado.") then
      
      uo.deletejournal();
      UO.Cast('Magic Arrow','self')
      wait(1000)
   end if
   uo.deletejournal();
   
end sub

sub verificaECuraPoison() 
   If UO.Poisoned() then
      
      if UO.InJournal("paralisado") then
         desparaliza()
      end if 
      uo.deletejournal();
      If UO.Count('0x0F0E','0x002C')>0 then
         uo.deletejournal();
         UO.UseType('0x0F0E','0x002C');
         uo.deletejournal();
         if UO.InJournal("seg") then
            UO.Cast('Cure','self')
            wait(300);
            uo.deletejournal();
            if UO.InJournal("A magia falhou") then
               verificaECuraPoison()
            end if
            wait(3000);
         end if
      else
         UO.Cast('Cure','self')
         wait(300);
         uo.deletejournal();
         if UO.InJournal("A magia falhou") then
            verificaECuraPoison()
         end if
         wait(3000);
      end if
      
   end if
   
end sub

sub verificaHeal();CuraPoison
   if UO.Life < UO.str then 
      if UO.Life < 20 then 
         UO.UseType('0x0F0E','0x00FF');
      End If 
      If UO.Count('0x0E21')>0 then
         UO.WaitTargetSelf()
         UO.UseType('0x0E21')
      Else
         UO.Cast('Heal','self')
      End If 
      #uo.equip('Rhand',arma)
   End If
end sub

sub ressaNaBandage()
   UO.AddObject ('AMIGO')
   While UO.Targeting()
      Wait(100)
   Wend
   var  amigo = uo.getserial('AMIGO');
   UO.UseType('0x0E21');
   uo.waittargetobject(amigo)
   
end sub 

sub veritem()
   var ItemName, ItemID, ItemType, ItemColor
   uo.findtype(-1,-1,'my')
   #uo.click('finditem')
   UO.Click('lasttarget')
   UO.DeleteJournal() 
   ItemColor=UO.GetColor('lasttarget')
   ItemName=UO.GetName('lasttarget')
   ItemID=UO.GetSerial('lasttarget')
   ItemType=UO.GetGraphic(UO.GetSerial( 'lasttarget')) 
   #ItemColor=UO.GetColor('finditem')
   uo.Print(ItemName +', ' +ItemID +', ' +ItemType +', ' +ItemColor)
end sub

# ----------------------------------------------------------------------------------------------

sub verificaManaETomaPotionOuMedita()
   if UO.Mana < UO.int-50 then
      If UO.Count('0x0f0e','0x0480')>0 then
         UO.UseType('0x0f0e','0x0480');
      Else
         UO.UseSkill('Meditation')
      End If
   end if
end sub



sub marcaTarget();CuraPoison
   var eu =0;
   
   eu = uo.getserial('self');
   UO.AddObject ('INIMIGO')
   While UO.Targeting()
      Wait(100)
   Wend
   INIMIGO =  uo.getserial('INIMIGO');
   
   ;uo.useobject(INIMIGO);
end Sub

sub castClumsyNoInimigo() 
   uo.SetEasyUO(1,"0")
   var  objInimigo = uo.getserial('INIMIGO');
   ; verificaManaETomaPotionOuMedita();
   uo.cast('Magic Arrow',objInimigo);
end sub

sub castWeakenNoInimigo() 
   uo.SetEasyUO(1,"0")
   uo.Print("1")
   var  objInimigo = uo.getserial('INIMIGO');
   ;verificaManaETomaPotionOuMedita();
   uo.cast('Weaken',objInimigo);
end sub

sub castEBNoInimigo() 
   uo.SetEasyUO(1,"0")
   var  objInimigo = uo.getserial('INIMIGO');
   UO.Set('lasttarget',objInimigo) 
   ;verificaManaETomaPotionOuMedita();
   var scroll = uo.getserial('0x1F56');
   If UO.Count('0x1F56')>0 then
      UO.Set('lasttarget',objInimigo) 
      UO.Exec("usetype 0x1F56;waittargetlast") 
   Else
      UO.Cast('Energy Bolt',objInimigo)
   End If
   
end sub

sub castPoisonNoInimigo() 
   uo.SetEasyUO(1,"0")
   var  objInimigo = uo.getserial('INIMIGO');
   ;verificaManaETomaPotionOuMedita();
   uo.cast('Poison',objInimigo);
end sub

sub castParalyzeNoInimigo() 
   uo.SetEasyUO(1,"0")
   var  objInimigo = uo.getserial('INIMIGO');
   ;verificaManaETomaPotionOuMedita();
   uo.cast('Paralyze',objInimigo);
end sub

sub castFSNoInimigo()
   uo.SetEasyUO(1,"0")
   var  objInimigo = uo.getserial('INIMIGO');
   If UO.Count('0x1F5F')>0 then
      UO.Set('lasttarget',objInimigo) 
      UO.Exec("usetype 0x1F5F;waittargetlast") 
      ;uo.useobject(INIMIGO);
      ;UO.waittargettype('0x1F5F','0x0000');
      ;UO.UseType('0x1F5F','0x0000');
   Else
      UO.Cast('Flame Strike',objInimigo);
   End If
end Sub

sub castLightningNoInimigo() 
   uo.SetEasyUO(1,"0")
   var  objInimigo = uo.getserial('INIMIGO');
   UO.Set('lasttarget',objInimigo) 
   ;verificaManaETomaPotionOuMedita();
   var scroll = uo.getserial('0x1F56');
   UO.Cast('Lightning',objInimigo)
end sub

# ----------------------------------------------------------------------------------------------
sub itemid() ; Item ID
   uo.print('%autoload by SmaCk')
   uo.print('Item Identification 1.0 DMS Shard')
   While UO.SkillVal( 'Item ID' ) < 1028
      UO.Waittargettype('0x0EFA')
      UO.useskill('Item Identification')
      wait(2500)
   wend
   music()
end sub

# ----------------------------------------------------------------------------------------------


sub healpassive() ; Funcao q permite que você se heale, ao perder life, Usa-se Bandagens 
   while NOT UO.Dead() 
      repeat 
         if UO.Life < UO.str then 
            #UO.Exec("usetype 0x0E21") 
            #uo.waittargetself()
            UO.bandageself() 
            wait(4000) 
         endif 
      until UO.Life == UO.str 
   wend 
end sub 


sub FS()
   UO.WaitTargetLast()
   If UO.Count('0x1F5F')>0 then
      UO.UseType('0x1F5F')
   Else
      UO.Cast('Flame Strike')
   End If
end Sub


sub autostart()
end sub

sub main()
   UO.Print("Hello from function MAIN")
end sub

sub Mount()
   If UO.ObjAtLayer('Horse') Then
      UO.UseObject('self')
      UO.Msg('All Stay')
   Else
      UO.Msg('All Follow Me')
      UO.UseObject('pet')
   End If
End Sub

sub opendoor()
   var n
   Dim Door[30]
   Door[1]='0x0677'
   Door[2]='0x0675'
   Door[3]='0x06AF'
   Door[4]='0x06A6'
   Door[5]='0x1FF1'
   Door[6]='0x1FF3'
   Door[7]='0x083D'
   Door[8]='0x06EE'
   
   for n=1 to 8
      if uo.countground(Door[n]) then
         uo.usefromground(Door[n])
      endif
   next
end sub

sub closedoor()
   var n
   Dim Door[30]
   Door[1]='0x0676'
   Door[2]='0x0678'
   Door[3]='0x06B0'
   Door[4]='0x06A5'
   Door[5]='0x1FF4'
   Door[6]='0x1FF2'
   Door[7]='0x083E'
   Door[8]='0x06EE'
   
   for n=1 to 8
      if uo.countground(Door[n]) then
         uo.usefromground(Door[n])
      endif
   next
end sub

Sub b()
   Var Delay = 0, i, g=0
   While TRUE
      g=0
      UO.Press(200)
      If UO.Count('0x0E21') > 0 Then
         If UO.Life < UO.Str Then
            UO.BandageSelf()
            Repeat
               Wait(200)
               Delay = Delay + 1
            Until Delay > 25 OR UO.InJournal('Voce colocou bloody|Voce esta envenenado|Voce foi envenenado|You feel|Target is not in line of sight') == 1
            Delay = 0
            g = 1
         End If
      Else
         UO.CharPrint('0x0790','Voce nao tem Bandagens.')
         Wait(10000)
      End If
   wend
EndSub

Sub gatef()
   UO.Set('finddistance','14')
   uo.findtype("0x0F6C","-1","ground")
   if uo.findcount()>0 then
      UO.cast('Dispel','finditem')
      #            wait(10)
      #    uo.charprint('0x0000', '3 segundos');
      #    wait(1000)
      #    uo.charprint('0x0000', '2 Segundos');
      #    wait(1000)
      #    uo.charprint('0x0000', '1 Segundo!');
      #    wait(1060)
      #    uo.charprint('0x0000', 'Gate FECHADO!');
   endif
   if uo.findcount()==0 then
      uo.print('Nenhum gate encontrado!')
   endif  
   UO.Set('finddistance','14')
end sub

sub gaterapido()
   uo.exec("warmode 0")
   uo.waittargettype('0x22C5','0x0461')
   uo.cast('Gate Travel')
endsub

sub recallrapido()
   uo.exec("warmode 0")
   uo.waittargettype('0x22C5','0x0461')
   uo.cast('Recall')
   #wait(10)
   #uo.charprint('0x0099', '4 segundos');
   #wait(1050)
   #uo.charprint('0x0099', '3 segundos');
   #wait(1060)
   #uo.charprint('0x0099', '2 segundos');
   #wait(1070)
   #uo.charprint('0x0099', '1 segundo');
   #wait(1100)
   #uo.charprint('0x0099', 'Recall!');
   
   
endsub

sub leparrow()
   uo.cast('Magic Arrow')
   uo.waittargettype('0x0F0E','0x0015')
   wait (600)
   uo.msg('.disarm')
   UO.bandageself()
endsub



sub pff() ; Solta Paralyse Field em /
   Uo.waittargettile("400",str(Uo.getx("self")),str(Uo.gety("self")),str(Uo.getz("self"))) 
   uo.cast('Paralyze Field')
   wait(2000)
   uo.waittargetself()
   uo.usetype('0x0F0D','0x0021')
end sub

sub fire() ; Solta Paralyse Field em /
   var char='lasttarget' ;
   Uo.waittargettile('#0x400',Uo.getx(char),Uo.gety(char),Uo.getz(char)) 
   uo.cast('Fire Field')
   wait(2000)
   uo.waittargetself()
   uo.usetype('0x0F0D','0x0021')
end sub

sub lootbody() ; Macro de Lootiar pelo Corpo
   var i,n 
   dim A[2] 
   A[1] = 0x0EED ;GOLD
   A[2] = 0x0190 ; LOG
   i = 50
   for n=1 TO 1
      uo.findtype(A[n],"-1","lastcontainer") 
      if uo.findcount() > 0 then
         uo.grab(0,"finditem") 
         wait(i) 
      end if 
   next 
end sub

sub loo() ; Macro de Lootiar pelo Corpo
   var i,n 
   Dim R[12] 
   R[1] = 'AL1' ;item 1 
   R[2] = 'AL1' ;item 2 
   R[3] = 'AL1' ;item 3 
   R[4] = 'AL1' ;item 4 
   R[5] = 'AL5' ;item 5 
   R[6] = 'AL6' ;item 6 
   R[7] = 'AL7' ;item 7 
   R[8] = 'AL8' ;item 8 
   R[9] = 'AL9' ;item 9 
   R[10] = 'AL10' ;item 10 
   R[11] = 'AL11' ;item 11 
   R[12] = 'AL12' ;item 12 
   i = 50
   for n=1 TO 12
      uo.findtype(R[n],"-1","lastcontainer") 
      if uo.findcount() > 0 then
         uo.grab(0,"finditem") 
         wait(i) 
      end if 
   next 
end sub

sub lag()
   var a=0
   uo.deletejournal()
   uo.click('backpack')
   repeat
      a=a+1
      wait(1)
   until uo.injournal('backpack')
   uo.serverprint('Ping: '+ STR(A*2) + ' ms')
end sub

sub Stamvip()
   if uo.stamina<uo.dex then
      if (uo.dex-uo.stamina)< 21 then
         uo.usetype('0x1F03')
         uo.moveitem('bot','-1','my')
         wait(1500)
         uo.useobject('rob')
         uo.useobject('bot')
      else
         uo.msg('.drinkrefresh')
      endif
   endif
endsub

sub Stealth()
   ;wait(130)
   ;if uo.count("0x1F0B","0x0592") ==0 then ;ORC VISAGE 
   ;wait(10)
   tirar3()
end if
wait(10)
tirar2()
wait(10)
UO.Exec("useskill 'Stealth'")
wait(20)
uo.usetype('0x1415');PEITO /
wait(20)
uo.usetype('0x1416');PEITO \
wait(20)
uo.usetype('0x1410');ARMS /
wait(20)
uo.usetype('0x1417');ARMS \
wait(20)
endsub


sub Arms_Lore()
   uo.WaitTargetLast()
   uo.Useskill('Arms Lore')
   uo.say(",exec Arms_Lore")
End sub    

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
         Wait(500) 
      end if 
   NEXT 
   
end sub 

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

sub wallfire() ; Fecha o Player em X e Casta Fire Field. Favor rever os Delays nas linhas wait(4000) 
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
   wait(4000) 
   uo.waittargettile("400",str(uo.getx("lasttarget")+1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
   uo.cast("Wall of Stone") 
   wait(4000) 
   uo.waittargettile("400",str(uo.getx("lasttarget")+1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
   uo.cast("Fire Field") 
end sub 
;,waitmenu 'O' 'Platemail' '0' 'Iron Platemail Chest'
;,waitmenu 'Platemail' (0) 'Selecoes' (0)
sub macroDePlate();
   ;uo.findtype(0x0FB4)
   ;UO.CancelMenu()
   ;uo.waitmenu('Blacksmith','Platemail')
   ;UO.UseType('0x0FB4');	
   ;wait(4000)
   UO.Exec("usetype 0x1EB8")
   wait(700) 
   UO.WaitMenu ('Tinkering', 'Tools', 'NEXT PAGE', 'pickaxe' )
end sub

sub lootbodyGHZ2()
   var i,n,item
   
   dim A[1] 
   i = 500
   for n=1 TO 10
      item = 'AL'+str(n)
      
      uo.findtype(item,-1,'lastcontainer') 
      wait(150)
      if uo.findcount() > 0 then
         ;uo.info("finditem")
         uo.grab(0,"finditem") 
         wait(i)
      end if 
   next
end sub

sub lootbodyGHZ3()
   var i,n,item
   item = 'AL'+str(1)
   uo.findtype(item,-1,'lastcontainer') 
   uo.grab(0,"finditem") 
end sub

sub lootbodyGHZ() ; Macro de Lootiar pelo Corpo
   var i,n 
   dim A[19] 
   A[1] = 0x0EED ;GOLD
   A[2] = 0x0190 ; LOG
   A[3] = 0x1415 ; chest
   A[4] = 0x1417 ; arms
   A[5] = 0x1414 ; gloves
   A[6] = 0x1413 ; gorget
   A[7] = 0x141A ; legs
   A[8] = 0x1412 ; helmet
   A[9] = 0x1515 ; capa
   A[10] = 0x0F0E ; mana
   A[11] = 0x01F7 ; invis
   A[12] = 0x1B76 ; escudo
   A[13] = 0x0E21 ; bandage
   A[14] = 0x1087 ; bandage
   A[15] = 0x108A ; anel
   A[16] = 0x1542 ; s
   A[17] = 0x1411 ; helmet
   A[18] = 0x1410 ; helmet
   A[19] = 0x1418 ; helmet
   ; o resto
   i = 150
   for n=1 TO 19
      uo.findtype(A[n],"-1","lastcontainer") 
      wait(100)
      if uo.findcount() > 0 then
         ; UO.say("pegando "+str(A[n]))
         uo.grab(0,"finditem") 
         wait(i) 
      end if 
   next 
end sub


sub saidowarmode()
   while NOT UO.Dead() 
      UO.WarMode(0)
      wait(150)
   wend
end sub

sub autolootGHZ()
   VAR i, n
   VAR w = 500  ; the delay after a move
   VAR razmer = 10 ; the size of the DIM
   
   DIM Loot[10]
   Loot[1] = '0x0EED'
   Loot[2] = '0x1BD1'
   Loot[3] = '0x0F87'
   Loot[4] = '0x14ED'
   Loot[5] = '0x0EED'
   Loot[6] = '0x1031'
   Loot[7] = '0x0F51'
   Loot[8] = '0x0F51'
   Loot[9] = '0x0F06'
   Loot[9] = '0x1F31'
   
   
   if uo.getdistance( 'lastcorpse' ) < 5 then
      uo.deletejournal()
      repeat
         uo.findtype( '-1', '-1', 'lastcorpse' ) 
         n = 0
         for i = 1 to razmer
            if uo.getgraphic( 'finditem' ) == Loot[i] then
               uo.moveitem( 'finditem', 'all', 'my' )
               wait(w)
               if uo.injournal( 'UNSP' ) then
                  wait(w*2)
                  uo.deletejournal()
               endif
               n = 1
               goto nextitem
            endif         
         next
         if n == 0 then
            uo.ignore( 'finditem' )
         endif
      nextitem:
   until uo.findcount() == 0
else
   uo.print( 'The Corpse is too far' )
endif
end sub

sub targetNext()
   var totalFriend=21;
   var temp, name, t = 0, k, a, findResult = 0
   
   DIM friend[21]
   friend[0]='Logan'
   friend[1]='Devil'
   friend[2]='Bruninho Down'
   friend[3]='Eric CartmaN'
   friend[4]='B a l l a c K'
   friend[5]='BlackOUT'
   friend[6]='GHZATOMIC'
   friend[7]='Sheep'
   friend[8]='Laranja Mecanica'
   friend[9]='Choqueano'
   friend[10]='KillerJoness'
   friend[11]='Killinha'
   friend[12]='AchilleS'
   friend[13]='Lakkitow'
   friend[14]='rola'
   friend[15]='The Sexy' 
   friend[16]='lkS' 
   friend[17]='LepoLepo' 
   friend[18]='Soul Rebel' 
   friend[19]='SenSimilla' 
   friend[20]='Luzcifer' 
   friend[21]='GoD SoN' 
   
   
   uo.set('finddistance','10')
   uo.ignore('self')
   for t=0 to 1
      repeat
         uo.findtype('0x0190','-1','ground')
         findResult = uo.findCount();
         temp = 0;
         name = uo.getName('finditem');
         for k=0 to totalFriend
            if name == friend[k] and uo.findcount() <> 0 then
               uo.Ignore('finditem');
               k = totalFriend;
               temp = 1;
            endif
         next
         if temp==0 and findResult <> 0 then
            a = uo.getserial('finditem');
            UO.AddObject ('INIMIGO',a)
            uo.addobject('laststatus',a);
            uo.cast('Magic Arrow',a);
            uo.ignore('finditem');
            wait(100);
            uo.attack(a);
            return false
         endif
      until findResult == 0
      if findResult == 0 then
         uo.IgnoreReset()
      endif
   next
   uo.print('NGM NA AREA')
end sub
