Sub MagicArrow() # In Por Ylen
   UO.WaitTargetLast()
   UO.Cast('Magic Arrow')
   wait(10)
   UO.GetHP('lasttarget')
End If
EndSub

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

sub buffs()
   uo.cast('Reactive Armor','self')
   wait(3500)
   uo.cast('Protection','self')
   wait(2600)
   uo.cast('Strength','self')
   wait(2600)
   uo.cast('Magic Reflection','self')
end sub

sub Armas()
   # Feito por Meian
   var i
   dim arma[80]
   ; Escudos ; 68 a 80
   arma[1] = 0x1B7A ; Froswood Wooden Shield
   arma[2] = 0x1B72 ; Bronze Shield
   arma[3] = 0x1B76 ; Hearter Shield 1
   arma[4] = 0x1B77 ; Hearter Shield 2
   arma[5] = 0x1B7B ; Metal Shield
   arma[6] = 0x1B74 ; Metal Kit Shield 1
   arma[7] = 0x1B75 ; Metal kit Shield 2
   arma[8] = 0x1B78 ; Tear Kit Shield 1
   arma[9] = 0x1B79 ; Tear Kit Shield 2
   arma[10] = 0x1BC3 ; Chaos Shield
   arma[11] = 0x1BC4 ; Order Shield 1
   arma[12] = 0x1BC5 ; Order Shield 2
   ; Espadas e Lâminas ; 1 a 22
   arma[13] = 0x0F51 ; Dagger 1
   arma[14] = 0x0F52 ; Dagger 2
   arma[15] = 0x0F5E ; Broadsword 1
   arma[16] = 0x0F5F ; Broadsword 2
   arma[17] = 0x13B7 ; Longsword 1
   arma[18] = 0x13B8 ; Longsword 2
   arma[19] = 0x13B9 ; Vikingsword 1
   arma[20] = 0x13BA ; Vikingsword 2
   arma[21] = 0x13B5 ; Scimitar 1
   arma[22] = 0x13B6 ; Scimitar 2
   arma[23] = 0x13FE ; Katana 1
   arma[24] = 0x13FF ; Katana 2
   arma[25] = 0x1400 ; Kryss 1
   arma[26] = 0x1401 ; Kryss 2
   arma[27] = 0x1440 ; Cutlass 1
   arma[28] = 0x1441 ; Cutlass 2
   arma[29] = 0x26BB ; Boneharvester 1
   arma[30] = 0x26C5 ; Boneharvester 2
   arma[31] = 0x1404 ; Crescentblade 1
   arma[32] = 0x26CB ; Crescentblade 2
   arma[33] = 0x0f60 ; Longsword vanq 1
   arma[34] = 0x0f61 ; Longsword vanq 2
   ; Machados ; 23 a 36
   arma[35] = 0x0F49 ; Axe 1
   arma[36] = 0x0F4A ; Axe 2
   arma[37] = 0x0F45 ; Executioneraxe 1
   arma[38] = 0x0F46 ; Executioneraxe 2
   arma[39] = 0x0F47 ; Battleaxe 1
   arma[40] = 0x0F48 ; Battleaxe 2
   arma[41] = 0x13FA ; Large Battleaxe 1
   arma[42] = 0x13FB ; Large Battleaxe 2
   arma[43] = 0x0F4B ; Double Battleaxe 1
   arma[44] = 0x0F4C ; Double battleaxe 2
   arma[45] = 0x13AF ; War Axe 1
   arma[46] = 0x13B0 ; War Axe 2
   arma[47] = 0x1442 ; Two Handedaxe 1
   arma[48] = 0x1443 ; two Handedaxe 2
   ; Maças e Martelos ; 37 a 48
   arma[49] = 0x0F5C ; Mace 1
   arma[50] = 0x0F5D ; Mace 2
   arma[51] = 0x1406 ; WarMace 1
   arma[52] = 0x1407 ; WarMace 2
   arma[53] = 0x143A ; Maul 1
   arma[54] = 0x143B ; Maul 2
   arma[55] = 0x1438 ; War Hammer 1
   arma[56] = 0x1439 ; War Hammer 2
   arma[57] = 0x143C ; Hammer Pick 1
   arma[58] = 0x143D ; Hammer Pick 2
   arma[59] = 0x13B3 ; Scepter 1
   arma[60] = 0x26C6 ; Sceptr 2
   ; Armas de 2 Mãos ;  49 a 67
   arma[61] = 0x0F4D ; Bardiche 1
   arma[62] = 0x0F4E ; Bardiche 2
   arma[63] = 0x143E ; Halberd 1
   arma[64] = 0x143F ; Halberd 2
   arma[65] = 0x0F62 ; Spear 1
   arma[66] = 0x0F63 ; Spear 2
   arma[67] = 0x1402 ; Short Spear 1
   arma[68] = 0x1403 ; Short Spear 2
   arma[69] = 0x1404 ; War Fork 1
   arma[70] = 0x1405 ; War Fork 2
   arma[71] = 0x26BA ; Scythe 1 
   arma[72] = 0x26C4 ; Scythe 2
   arma[73] = 0x0E87 ; Pitchfork
   arma[74] = 0x13B4 ; Club
   arma[75] = 0x26BD ; BladedStaff 1
   arma[76] = 0x26BF ; Double Bladed Staff 1
   arma[77] = 0x26C9 ; Double Bladed Staff 2
   arma[78] = 0x26C0 ; Lance 1
   arma[79] = 0x26CA ; Lance 2
   arma[80] = 0x0E88 ; Pitchfork
   for i = 1 to 80
      if uo.count(arma[i])>=1 then
         uo.usetype(arma[i])
         wait(150)
         ;uo.fontcolor(UO.Random(100))
         ;uo.msg('This is Sparta!!')
      endif
   next
endsub

sub fsscroll()
   if uo.count("0x1F57")>0 then
      uo.waittargetlast()
      uo.useType("0x1F57")
   else
      if uo.count("0x1F5F 0x0000")>0 then
         uo.waittargetlast()
         uo.useType("0x1F5F 0x0000")
      else
         uo.waittargetlast()
         uo.cast("Energy Bolt")
      endif
   endif
endif
end sub

sub atropela() 
   if (uo.stamina >= 100) then
      wait(100)
      uo.findtype('0x170B',-1,'my')
      uo.moveitem('finditem',-1,'backpack')
      wait(350)
      uo.findtype('0x2684',-1,'my')
      uo.moveitem('finditem',-1,'backpack')
      wait(600)
      uo.usetype('0x2684')
      wait(300)
      uo.usetype('0x170B')
   else
      uo.say ('.drink Total Refresh')
      uo.say ('.drink Refresh')
   endif
end sub

sub pf2(); PF NO TARGET DO OPONENTE
   Uo.waittargettile("400",str(Uo.getx("lasttarget")),str(Uo.gety("lasttarget")),str(Uo.getz("lasttarget")))
   uo.cast('Paralyze Field')
end sub

Sub gate()
   UO.Set('finddistance','20')
   uo.findtype("0x0F6C","-1","ground")
   if uo.findcount()>0 then
      UO.cast('Dispel','finditem')
   endif
   if uo.findcount()==0 then
      uo.print('Nenhum gate encontrado!')
   endif  
   UO.Set('finddistance','14')
end sub

sub Mount()
   If UO.ObjAtLayer('Horse') Then
      UO.UseObject('self')
      UO.Msg('All Stay')
      wait(100)
      UO.Msg('All Kill')
   Else
      UO.Msg('All Come')
      UO.UseObject('pet')
   End If
End Sub

#-----------------------------------#
#---------- Target Players ---------#
#-----------------------------------#

sub Target_Next() 
   
   var totalFriend=20
   var temp, name, i, t = 0, k, a, findResult = 0
   DIM friend[21]
   friend[0]='Nina'
   friend[1]='nerv'
   friend[2]='Kadaj'
   friend[3]='Black Owl'
   friend[4]='Mohammed ali'
   friend[5]='Dragoon'
   friend[6]='Scott DisicK'
   friend[7]='SethM'
   friend[8]='TanatoS'
   friend[9]='SimulacrO'
   friend[10]='Indigesto'
   friend[11]='StellA ArtoiS'
   friend[12]='BuD'
   friend[13]='x CHUCK NORRIS x'
   friend[14]='Bo Rai Cho'
   friend[15]='The Knight'
   friend[16]='Goema'
   friend[17]='E r e m i t a'
   friend[18]='The Sexy' 
   
   DIM b[2]
   b[1] = '0x0190'
   b[2] = '0x0191'
   
   uo.set('finddistance','14')
   uo.ignore('self')
   for t=0 to 1
      for i=1 to 2
         repeat
            uo.findtype(b[i],'-1','ground')
            findResult = uo.findCount()
            temp = 0
            name = uo.getName('finditem')
            for k=0 to totalFriend
               if name == friend[k] and uo.findcount() <> 0 then
                  uo.Ignore('finditem')
                  k = totalFriend
                  temp = 1
               end if
            next
            if temp==0 and findResult <> 0 then
               a = uo.getserial('finditem')
               uo.addobject('laststatus',a)
               uo.addobject('lasttarget',a)
               uo.addobject('Enemy',uo.getserial("finditem"))
               Uo.charprint ('0x0058', "Target = "+uo.getname('Enemy'))
               #Uo.print (".")
               #Uo.say(".gc [Target] "+uo.getname('Enemy'))
               uo.ignore('finditem')
               if uo.getnotoriety('finditem')>= 1 then
                  uo.cast('Magic Arrow',a)
                  wait(100)
                  uo.attack(a)
               end if
               return false
            end if
         until findResult == 0
         if findResult == 0 then
            uo.IgnoreReset()
         end if
      next
      uo.charprint('0x0021', 'Ninguém na Área')
end sub

sub Ress()
   VAR n
   Dim ress[2]
   ress[1] = '0x0192'
   ress[2] = '0x0193'
   UO.Set('finddistance','14')
   For n = 1 To 2
      uo.findtype( ress[n] , -1 ,'ground')
      if uo.findcount() then
         uo.waittargetobject('finditem')
         if uo.mana < 50 then
            uo.usetype('0x0E21')
         endif
         if uo.mana >= 60 then
            uo.cast('Resurrection')
         endif
      end if
   Next
end sub

sub corta_corpo()
   var i
   DIM arma[79]
   arma[1] = 0x0F51 ; Dagger 1
   arma[2] = 0x0F52 ; Dagger 2
   arma[3] = 0x0F5E ; Broadsword 1
   arma[4] = 0x0F5F ; Broadsword 2
   arma[5] = 0x13B7 ; Longsword 1
   arma[6] = 0x13B8 ; Longsword 2
   arma[7] = 0x13B9 ; Vikingsword 1
   arma[8] = 0x13BA ; Vikingsword 2
   arma[9] = 0x13B5 ; Scimitar 1
   arma[10] = 0x13B6 ; Scimitar 2
   arma[11] = 0x13FE ; Katana 1
   arma[12] = 0x13FF ; Katana 2
   arma[13] = 0x1400 ; Kryss 1
   arma[14] = 0x1401 ; Kryss 2
   arma[15] = 0x1440 ; Cutlass 1
   arma[16] = 0x1441 ; Cutlass 2
   arma[17] = 0x26BB ; Boneharvester 1
   arma[18] = 0x26C5 ; Boneharvester 2
   arma[19] = 0x26C1 ; Crescentblade 1
   arma[20] = 0x26CB ; Crescentblade 2
   arma[21] = 0x0f60 ; Longsword vanq 1
   arma[22] = 0x0f61 ; Longsword vanq 2
   arma[23] = 0x0F49 ; Axe 1
   arma[24] = 0x0F4A ; Axe 2
   arma[25] = 0x0F45 ; Executioneraxe 1
   arma[26] = 0x0F46 ; Executioneraxe 2
   arma[27] = 0x0F47 ; Battleaxe 1
   arma[28] = 0x0F48 ; Battleaxe 2
   arma[29] = 0x13FA ; Large Battleaxe 1
   arma[30] = 0x13FB ; Large Battleaxe 2
   arma[31] = 0x0F4B ; Double Battleaxe 1
   arma[32] = 0x0F4C ; Double battleaxe 2
   arma[33] = 0x13AF ; War Axe 1
   arma[34] = 0x13B0 ; War Axe 2
   arma[35] = 0x1442 ; Two Handedaxe 1
   arma[36] = 0x1443 ; two Handedaxe 2
   ; Maças e Martelos ; 37 a 48
   arma[37] = 0x0F5C ; Mace 1
   arma[38] = 0x0F5D ; Mace 2
   arma[39] = 0x1406 ; WarMace 1
   arma[40] = 0x1407 ; WarMace 2
   arma[41] = 0x143A ; Maul 1
   arma[42] = 0x143B ; Maul 2
   arma[43] = 0x1438 ; War Hammer 1
   arma[44] = 0x1439 ; War Hammer 2
   arma[45] = 0x143C ; Hammer Pick 1
   arma[46] = 0x143D ; Hammer Pick 2
   arma[47] = 0x26BC ; Scepter 1
   arma[48] = 0x26C6 ; Sceptr 2
   ; Armas de 2 Mãos ;  49 a 67
   arma[49] = 0x0F4D ; Bardiche 1
   arma[50] = 0x0F4E ; Bardiche 2
   arma[51] = 0x143E ; Halberd 1
   arma[52] = 0x143F ; Halberd 2
   arma[53] = 0x0F62 ; Spear 1
   arma[54] = 0x0F63 ; Spear 2
   arma[55] = 0x1402 ; Short Spear 1
   arma[56] = 0x1403 ; Short Spear 2
   arma[57] = 0x1404 ; War Fork 1
   arma[58] = 0x1405 ; War Fork 2
   arma[59] = 0x26BA
   arma[60] = 0x26C4 ; Scythe 2
   arma[61] = 0x26BE ; Pike 1
   arma[62] = 0x26C8 ; Pike 2
   arma[63] = 0x0E88 ; BladedStaff 1
   arma[64] = 0x26BF ; Double Bladed Staff 1
   arma[65] = 0x26C9 ; Double Bladed Staff 2
   arma[66] = 0x0E87 ; Pitchfork
   arma[67] = 0x26CA ; Lance 2
   ; Escudos ; 68 a 80
   arma[68] = 0x1B73 ; Buckler
   arma[69] = 0x1B72 ; Bronze Shield
   arma[70] = 0x1B76 ; Hearter Shield 1
   arma[71] = 0x1B77 ; Hearter Shield 2
   arma[72] = 0x1B7B ; Metal Shield
   arma[73] = 0x1B74 ; Metal Kit Shield 1
   arma[74] = 0x1B75 ; Metal kit Shield 2
   arma[75] = 0x1B78 ; Tear Kit Shield 1
   arma[76] = 0x1B79 ; Tear Kit Shield 2
   arma[77] = 0x1BC3 ; Chaos Shield
   arma[78] = 0x1BC4 ; Order Shield 1
   arma[79] = 0x1BC5 ; Order Shield 2
   for i = 1 to 67
      if uo.count(arma[i]) > 0 then
         uo.waittargetground('0x2006','0x83EA')
         uo.usetype(arma[i])
         wait(150)
         uo.say('.disarm')
      endif
   next
   uo.exec('exec corpo_picado')
end sub
sub corpo_picado()
   var loop
   DIM BoneCorpse[9]
   BoneCorpse[0]='0x2006' ; type osso
   BoneCorpse[0]='0x0ECA' ; type osso
   BoneCorpse[1]='0x0ECB' ; type osso
   BoneCorpse[2]='0x0ECC' ; type osso
   BoneCorpse[3]='0x0ECD' ; type osso
   BoneCorpse[4]='0x0ECE' ; type osso
   BoneCorpse[5]='0x0ECF' ; type osso
   BoneCorpse[6]='0x0ED0' ; type osso
   BoneCorpse[7]='0x0ED1' ; type osso
   BoneCorpse[8]='0x0ED2' ; type osso
   For loop=0 to 8
      UO.FindType(BoneCorpse[loop],'-1','ground')
      If UO.FindCount()>0 Then
         UO.UseObject('finditem')
         Wait(200)
      End If
   Next
end sub

sub cat()
   uo.usetype('0x211B')
   uo.usetype('0x20EF')
   uo.usetype('0x211C')
   UO.Msg('Taurus! Eu escolho você!')
end sub

sub JogarBolas()
   If UO.ObjAtLayer('Horse') Then
      UO.UseObject('self')
   else
      uo.waittargetlast()
      UO.Usetype('0x26AC','0x0000')
      wait(500)
      UO.UseObject('Horse')
   End If
End Sub


sub startcookingMacro()
   uo.print("Macro by SexStyle")
   uo.print("Clique onde estao as rawfishs")
   uo.addobject("Bau")
   while uo.targeting()
      wait(100)
   wend
   cookingmacro()
endsub

sub cookingmacro()  
   while UO.SkillVal('Cooking') < 1100
      uo.useobject("Bau")
      wait(500)
      uo.findtype('0x09B7','0x0000',"backpack")
      uo.moveitem('finditem','all','Bau')
      wait(2000)
      uo.findtype('0x09B9','0x0000',"Bau")
      uo.grab("1","finditem")
      wait(2000)
      repeat
      wend
endsub 

sub fazerultimo()
   var timeout=0
   while NOT uo.dead()
      uo.Lclick(323,442) ; # coordenada da opção 'Fazer ultimo'. se necessário, mudar.
      repeat
         wait(1000)
         timeout=timeout+1
      until uo.injournal('Voce ') or timeout==10  # Tempo limite de 10 segundos
      timeout=0
      uo.deletejournal()
   wend
endsub

sub scriptComprar(num, nome, lista)
   while uo.weight < num
      uo.useobject('Vendor')
      wait(300)
      uo.buy(lista,nome)
      wait(300)
   wend
   uo.charprint('0x0021','Compras Finalizadas')
endsub

sub comprar()
   uo.charprint('0x0021','Macro Feito por Dracula')
   wait(500)
   uo.charprint('0x0021','Clique no vendedor')
   uo.addobject('Vendor')
   while uo.targeting()
      wait(100)
   wend
   scriptComprar(500, 'Jabir', 'eyes of newt')
endsub

sub mantlee()
   uo.exec('usetype 0x1F03;usetype 0x1F04;usetype 0x170D;usetype 0x1711')
   wait(800)
   uo.exec('usetype 0x2684;usetype 0x1F03;usetype 0x108A')
end sub

sub band()
   uo.waittargetself()
   uo.usetype('0x0E21')
endsub

sub botamantle()
   var t=0
   var x=uo.dex
   uo.DeleteJournal()
   if uo.stamina >= x-5 then
      uo.moveitem('bota_vip','-1','backpack')
      repeat
         wait(100)
         t = t+1
      until uo.injournal('seu caminho') or t > 14
      uo.useobject('bota_vip')
   else
      if uo.stamina >= x-15 then
         uo.moveitem('mantle','-1','backpack')
         repeat 
            wait(100) 
            t = t+1 
         until uo.injournal('seu caminho') or t > 14 
         uo.useobject('mantle')
      else 
         if uo.stamina >= x-20 then
            uo.moveitem('mantle','-1','backpack')
            wait(350)
            uo.moveitem('bota_vip','-1','backpack')
            repeat
               wait(100)
               t = t+1
            until uo.injournal('seu caminho') or t > 14
            uo.useobject('mantle')
            uo.useobject('bota_vip')
         else
            if uo.count('0x09CC','0x0042') > 0 then 
               if uo.stamina >= x-25 then 
                  uo.usetype('0x09CC','0x0042') 
                  wait(100) 
                  uo.moveitem('mantle','-1','backpack')
                  repeat 
                     wait(100) 
                     t = t+1 
                  until uo.injournal('seu caminho') or t > 14
                  uo.useobject('mantle') 
               else 
                  if uo.stamina >= x-30 then
                     uo.usetype('0x09CC','0x0042')
                     wait(100)
                     uo.moveitem('mantle','-1','backpack')
                     wait(350)
                     uo.moveitem('bota_vip','-1','backpack')
                     repeat
                        wait(100)
                        t = t+1
                     until uo.injournal('seu caminho') or t > 14
                     uo.useobject('mantle')
                     uo.useobject('bota_vip')
                  else
                     if uo.stamina >= x-35 then
                        uo.usetype('0x09CC','0x0042')
                        wait(1500)
                        uo.usetype('0x09CC','0x0042')
                        wait(100)
                        uo.moveitem('mantle','-1','backpack')
                        repeat
                           wait(100)
                           t = t+1
                        until uo.injournal('seu caminho') or t > 14
                        uo.useobject('mantle')
                     else
                        if uo.stamina >= x-40 then
                           uo.usetype('0x09CC','0x0042')
                           wait(1500)
                           uo.usetype('0x09CC','0x0042')
                           wait(100)
                           uo.moveitem('mantle','-1','backpack')
                           wait(350)
                           uo.moveitem('bota_vip','-1','backpack')
                           repeat
                              wait(100)
                              t = t+1
                           until uo.injournal('seu caminho') or t > 14
                           uo.useobject('mantle')
                           uo.useobject('bota_vip')
                        else
                           uo.msg('.drink Total Refresh')
                           uo.msg('.drink Refresh')
                        endif
                     endif
                  endif
               endif
            else
               uo.msg('.drink Total Refresh')
               uo.msg('.drink Refresh')
            endif
         endif
      endif
   endif
end sub

sub LooterNeww()
   VAR i, n
   VAR w = 2000  ; the delay after a move
   VAR razmer = 1  ; the size of the DIM
   
   DIM Loot[1]
   Loot[1] = '0x0EED';GOLD
   
   
   if uo.getdistance( 'lastcorpse' ) < 3 then
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
   uo.print( 'O Corpo Está Muito Longe' )
endif
endsub

sub teleportbaixoo() ; Teleporte para Baixo
   uo.warmode(0)
   UO.WaitTargetTile("100",str(uo.getx("self")),str(uo.gety("self")),str(uo.getz("self")-15))
   UO.Cast("Teleport")
   wait(50)
endsub

sub Smeltar()
   var n
   UO.Print('Selecione o bau que ira pegar/jogar os ores/ingots')
   UO.AddObject('BauSmelt')
   While UO.Targeting()
      Wait(1)
   Wend
   UO.Print('Selecione o martelo')
   UO.AddType('martelo')
   While UO.Targeting()
      Wait(1)
   Wend
   UO.UseType('martelo')
   n=0
   While True
      UO.Print('Pegando 100 Ingots ...')
      UO.FindType('0x19B9','-1','BauSmelt')
      UO.MoveItem('finditem','100','backpack')
      UO.DeleteJournal()
      Wait(300)
      While NOT UO.Injournal('Voce esmeltou')
         UO.UseType('0x19B9')
         UO.UseType('0x19B8')
         UO.UseType('0x19B7')
         UO.UseType('0x19BA')
         Wait(100)
      Wend
      n=n+1
      if n==10 Then
         While UO.Count('0x1BF2') > 0
            UO.FindType('0x1BF2','-1','backpack')
            UO.MoveItem('finditem','0','BauSmelt')
         Wend
         n=0
      EndIf
      Wait(2000)
   Wend
EndSub

sub Recall2()
   uo.warmode(0)
   wait(10)
   
   If UO.Count('0x1F14') Then
      UO.Cast('Recall') ; Recall
      UO.WaitTargetType('0x1F14')
   Endif
   uo.exec('exec Stealth')
End sub

Sub Stealth()
   wait(150)
   uo.findtype(0x1415,"-1","my")
   uo.moveitem('finditem','Chest','backpack')
   uo.findtype(0x1416,"-1","my")
   uo.moveitem('finditem','Chest','backpack')
   wait(100)
   uo.useskill('Hiding')
   wait(500)
   uo.usetype('0x1415')
   uo.usetype('0x1416')
end sub

sub pegarbau()
   uo.findtype('0x0E7D','0x0000','1','backpack')
   uo.moveitem('finditem','-1','backpack')
endsub

sub jogarbau()
   uo.findtype('0x0E7D','0x0000','-1','backpack')
   uo.moveitem('finditem','1','ground')
endsub

Sub CreateFile()
   UO.Click('self')
   Wait(500)
   Var F=File('D:\DMSSHARD - '+UO.GetName('self')+'.MMacro')
   Var S
   Var Count, i
   Var x,y
   Count = 0
   
   DIM SpotT[500] # Tile
   DIM SpotX[500] # Tile X
   DIM SpotY[500] # Tile Y
   DIM CharX[500] # Char X
   DIM CharY[500] # Char Y
   
   UO.MFGI('clear')
   Repeat
      Count = Count + 1
      UO.CharPrint('0x0790',' ')
      UO.CharPrint('0x0790',' ')
      UO.CharPrint('0x0790','Selecione o proximo Spot...')
      UO.Print('Para terminar, clique no seu Char.')
      Pickaxe()
      While NOT UO.Targeting()
         Wait(100)
      Wend
      While UO.Targeting()
         Wait(100)
      Wend
      
      SpotT[Count] = UO.LastTile(0)
      SpotX[Count] = UO.LastTile(1)
      SpotY[Count] = UO.LastTile(2)
      CharX[Count] = UO.GetX()
      CharY[Count] = UO.GetY()
      
      IF UO.LastTile(0) == 400 OR UO.LastTile(0) == 401 Then
         UO.CharPrint('0x063',' ')
         UO.CharPrint('0x063',' ')
         UO.CharPrint('0x063','Voce marcou "'+STR(Count-1)+'" Spots. Salvando...')
      Else
         UO.ConColor('0x044')
         UO.Print('Spot "'+STR(Count)+'" adicionado.')
         UO.ConColor('0x077a')
         For x = -2 To 2
            For y = -2 To 2
               UO.MFGI('add','0x1EA7',STR(UO.LastTile(1)+x),STR(UO.LastTile(2)+y),STR(UO.LastTile(3)),'0x0480')
            Next
         Next
      End IF
   Until UO.LastTile(0) == 400 OR UO.LastTile(0) == 401
   UO.ConColor('0x044')
   
   UO.MFGI('clear')
   
   F.Open()
   F.Create()
   S=Safe Call F.WriteLN(STR(Count - 1))
   For i=1 TO Count - 1
      S=Safe Call F.WriteLN(STR(SpotT[i])+' '+STR(SpotX[i])+' '+STR(SpotY[i])+' '+STR(CharX[i])+' '+STR(CharY[i]))
   Next
   F.Close()
End Sub


Sub Pickaxe()
   Var n = 0
   DIM Pickaxe[12]
   Pickaxe[1] = '0x0E85'
   Pickaxe[2] = '0x0E86'
   
   For n = 1 TO 2
      UO.FindType(Pickaxe[n],-1,'backpack')
      IF UO.FindCount() Then
         UO.UseType(Pickaxe[n])
         n = 2
      Else
         IF UO.GetGraphic(UO.ObjAtLayer('Rhand')) == Pickaxe[n] Then
            UO.UseType(Pickaxe[n])
            n = 2
         End IF
      End IF
   Next
End Sub

sub fazerpotevazio()
   var n
   UO.Print('Selecione o bau que ira pegar os ingots/jogar os potes')
   UO.AddObject('BauPote')
   While UO.Targeting()
      Wait(1)
   Wend
   UO.Print('Selecione o tinker tools')
   UO.AddType('tinker tools')
   While UO.Targeting()
      Wait(1)
   Wend
   UO.UseType('tinker tools')
   n=0
   While True
      UO.Print('Pegando 200 Ingots ...')
      UO.FindType('0x1BF2','-1','BauPote')
      UO.MoveItem('finditem','200','backpack')
      UO.DeleteJournal()
      Wait(300)
      While NOT UO.Injournal('Voce pos')
         UO.UseType('0x1EB8')
         UO.UseType('0x1EB9')
         Wait(100)
         uo.Lclick(323,442) ; # coordenada da opção 'Fazer ultimo'. se necessário, mudar.
         wait(2000)
      Wend
      n=n+1
      if n==10 Then
         While UO.Count('0x0F0E') > 0
            UO.FindType('0x0F0E','-1','backpack')
            UO.MoveItem('finditem','0','BauPote')
         Wend
         n=0
      EndIf
      Wait(2000)
   Wend
EndSub

sub StaminaDoAntraX()
   var x=uo.dex
   uo.DeleteJournal()
   if uo.stamina >= x-0 then
      uo.print ('Pode Passar!')
   else
      if uo.stamina >= x-5 then
         uo.moveitem('bota','-1','backpack')
         repeat
            wait(150)
            UO.Print('Pode Passar!')
            wait(450)
            uo.useobject('bota')
         else
            if uo.stamina >= x-10 then
               uo.moveitem('bota','-1','backpack')
               wait(350)
               uo.moveitem('ring','-1','backpack')
               repeat
                  wait(150)
                  UO.Print('Pode Passar!')
                  wait(450)
                  uo.useobject('bota')
                  uo.useobject('ring')
               else
                  if uo.stamina >= x-15 then
                     uo.moveitem('robe','-1','backpack')
                     repeat
                        wait(150)
                        UO.Print('Pode Passar!')
                        wait(450)
                        uo.useobject('robe')
                     else
                        if uo.stamina >= x-20 then
                           uo.moveitem('robe','-1','backpack')
                           wait(350)
                           uo.moveitem('ring','-1','backpack')
                           repeat
                              wait(150)
                              UO.Print('Pode Passar!')
                              wait(450)
                              uo.useobject('robe')
                              uo.useobject('ring')
                           else
                              if uo.stamina >= x-30 then
                                 uo.msg('.drink Total Refresh')
                              endif
                           endif
                        endif
                     endif
                  endif
               endif
endsub

sub dispelapf()
   UO.Set('finddistance','1')                   
   uo.findtype("0x3967","-1","ground")
   uo.findtype("0x3967","-1","ground")
   if uo.findcount()>0 then
      UO.cast('Dispel','finditem')              
   endif
   if uo.findcount()==0 then   
   endif  
   UO.Set('finddistance','1')                   
   uo.findtype("0x3979","-1","ground")
   uo.findtype("0x3979","-1","ground")
   if uo.findcount()>0 then
      UO.cast('Dispel','finditem')              
   endif
   if uo.findcount()==0 then
   endif  
   UO.Set('finddistance','1')
endif
end sub

sub gate_runa()
   uo.warmode(0)
   UO.WaitTargettype("0x1F15")
   UO.Cast("Gate Travel")
   wait(200)
   uo.useskill("Hiding")
end sub

sub fazer()
   uo.print('Macro de fazer SS Excep por BreatH')
   var timeout=0
   uo.deletejournal()
   uo.print('Selecione o CONTAINER/BAU:')
   uo.addobject('bau')
   while uo.targeting()
      wait(100)
   wend
   uo.print('Selecione o MARTELO:')
   uo.addobject('hammer')
   while uo.targeting()
      wait(100)
   wend
   inicio:
   uo.deletejournal()
   uo.useobject('hammer')
   wait(500)
   uo.lclick(326,440)
   repeat
      wait(1)
      timeout=timeout+1
   until uo.injournal('Voce pos|Voce falhou') or timeout==10000
   timeout=0
   if uo.injournal('Exceptional') then
      uo.findtype('0x0F45','my')
      uo.moveitem('finditem','0','bau')
   else
      derreter:
      uo.useobject('hammer')
      wait(500)
      uo.waittargettype('0x0F45')
      uo.lclick(68,400)
      wait(300)
      if uo.count('0x0F45')>0 then
         goto derreter
      endif
   endif
   wait(500)
   goto inicio
end sub

sub cplant()
   var i,n 
   uo.set('finddistance','15')
   Dim A[27] 
   A[1] = 0x0CA7 ; Rushes
   A[2] = 0x0CA1 ; Large Fern
   A[3] = 0x0CA3 ; FERN
   A[4] = 0x0CA4 ; FERN
   A[5] = 0x0CA5 ; PAMPAS GRASS
   A[6] = 0x0CAE ; GRASSES
   A[7] = 0x0CB2 ; GRASSES
   A[8] = 0x0CA2 ; FERN
   A[9] = 0x0CA1 ; LARGE FERN
   A[10] = 0x0CA0 ; FERN
   A[11] = 0x0C9F ; FERN
   A[12] = 0x0C98 ; FAN PLANT
   A[13] = 0x0C97 ; ELEPHANT EAT PLANT
   A[14] = 0x0C94 ; BULRUSHES
   A[15] = 0x0C93 ; 0X0C93
   A[16] = 0x0CA6 ; PONYTAIL PALM
   A[17] = 0x0CC4 ; PAMPAS GRASS
   A[18] = 0x0CB0 ; GRASSES
   A[19] = 0x0CA9 ; SNAKE PLANT
   A[20] = 0x0CB3 ; GRASSES
   A[21] = 0x0CB4 ; GRASSES
   A[22] = 0x0CB1 ; GRASSES
   A[23] = 0x0CAC ; GRASSES
   A[24] = 0x0CAD ; GRASSES
   A[25] = 0x0CB6 ; GRASSES
   A[26] = 0x0CB5 ; GRASSES
   A[27] = 0x0CAF ; GRASSES
   
   i=150
   for n = 1 to 27
      uo.findtype(A[n],"-1","ground") 
      if uo.findcount() > 0 then
         UO.useobject("finditem") 
         uo.click('finditem')
         Wait( i ) 
      end if 
   NEXT 
end sub

sub colar()
   uo.usetype('0x1088')
endsub

sub Ress()
   var i
   Dim a[2]
   a[1] = '0x0192'
   a[2] = '0x0193'
   UO.Set('finddistance','3')
   For i=1 to 2
      uo.findtype(a[i], -1, 'ground')
      if uo.findcount() then
         uo.waittargetobject('finditem')
         if uo.count('0x0E21')>80 then
            uo.usetype('0x0E21')
         else
            uo.cast('Resurrection')
         endif
         return
      end if
   Next
end sub

sub macroBS()
   var ingot = '0x1BEF'
   var cor = '0x0000'
   var shapedIron = '0x1BD7'
   var corShaped = '0x03bb'
   
   uo.print('Macro de bs BY Borsatti')
   wait(2000)
   
   uo.print('Selecione o bau onde vai pegar/guardar')
   uo.addobject('bauIron')
   while uo.targeting()
      wait(500)
   wend
   
   uo.print('Selecione o martelo')
   uo.addobject('martelo')
   while uo.targeting()
      wait(500)
   wend
   
   while uo.life > 1
      
      if uo.count(ingot,cor) < 1 then
         uo.findtype(ingot,cor,'bauIron')
         uo.moveitem('finditem',2000,'my')
         wait(1000)          
      endif
      
      while uo.count(ingot,cor) > 10
         
         if uo.count(ingot,cor) < 50 then
            uo.findtype(ingot,cor,'bauIron')
            uo.moveitem('finditem',2000,'my')
            wait(1000)          
         endif
         
         if uo.count(shapedIron,corShaped) > 100 then
            uo.findType(shapedIron,corShaped,'my')
            uo.moveitem('finditem',-1,'bauIron')
            wait(1000)
         endif
         
         uo.deleteJournal()
         uo.cancelMenu()
         uo.useobject('martelo')
         uo.usetype(ingot,cor)
         uo.waitmenu('Blacksmithing','Shaped Iron')
         while not uo.injournal('You put|falhou|cancelada|cancelou')
            wait(500)
         wend
         
      wend                             
      
   wend
   
end sub

sub cutbody()
   uo.set('finddistance','3')
   wait(100)
   uo.findtype('0x2006','-1','ground')
   if uo.findcount() then
      uo.waittargetobject('finditem')
      uo.useobject('lol')
      wait(250)
      uo.say('.disarm')
   end if
end sub

sub chainscroll()
   if uo.count("0x1F5D")>0 then
      uo.waittargetlast()
      uo.useType("0x1F5D")
   else
      uo.waittargetlast()
      uo.cast("Lightning")
   endif
endif
endif
end sub

sub loot() ;
   var i,n 
   Dim A[24] 
   A[1] = 0x1F5F ;Flame Strike Scroll 
   A[2] = 0x0F82 ;Mana Boost
   A[3] = 0x1F5F ;Peito
   A[4] = 0x0F82 ;Peito 2
   A[5] = 0x1411 ;Legs
   A[6] = 0x141A ;Legs 2
   A[7] = 0x1410 ;Arms
   A[8] = 0x1417 ;Arms 2
   A[9] = 0x1414 ;Gloves
   A[10] = 0x1418 ;Gloves
   A[11] = 0x1413 ;Gorget
   A[12] = 0x0E76 ;BANDS
   A[13] = 0x1545 ;Bear Mask
   A[14] = 0x1546 ;bear nova
   A[15] = 0x0E76 ;Anel
   A[16] = 0x0F82 ;pocao normal
   A[17] = 0x0EED ;robe
   A[18] = 0x0ef0 ;GOLD
   A[19] = 0x175D ;pano
   A[20] = 0x1C04 ;peito female
   A[21] = 0x1C05 ;peito female 2
   A[22] = 0x1BC4 ;order
   A[23] = 0x1BC5 ;order 2
   A[24] = 0x1BC3 ;chaos
   i = 50
   FOR n=1 TO 19
      uo.findtype(A[n],"-1","lastcontainer") 
      if uo.findcount() > 0 then
         UO.grab(0,"finditem") 
         Wait(i) 
      end if 
   NEXT 
end sub

sub Tama() ; Tamming TFG SHARD by LadoK
   VAR akl='K',axz='b',amn='o',ast='L',aop='d',auv='y',aqr='a'
   var k
   var count=0
   uo.print(axz+auv+' '+ast+aqr+aop+amn+akl)
   wait(500)
   uo.print('Selecione o ANIMAL a ser tamado')
   uo.exec('addobject ANIMAL')
   while uo.targeting()
      wait(100)
   wend
   count=0
   UO.DeleteJournal()
   while NOT UO.Dead()
      k=0
      UO.DeleteJournal()
      UO.WaitTargetObject('ANIMAL')
      ;UO.useskill('Animal Taming')
      uo.usetype('0x0EB2','0x0185')
      wait(100)
      repeat
         k=k+1
         wait(200)
      until UO.InJournal('Voce falhou') OR UO.InJournal('too far') or ( k > 40 ) OR UO.InJournal('aceita voce') OR UO.InJournal('aceita voce')
      If Uo.InJournal('aceita voce') Then
         uo.waittargetobject('ANIMAL')
         uo.usetype('0x0F0E','0x0076')
         UO.exec('Terminate All')
      Endif
      count=count+1
      uo.print('Tentativas : '+str(count))
   wend
end sub