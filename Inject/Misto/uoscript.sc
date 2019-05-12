

sub autostart()
   uo.SetEasyUO(1,"0")
   uo.SetEasyUO(2,"0")
   uo.SetEasyUO(3,"0")
   healpassive()
end sub

sub chain()
   uo.cast("Chain Lightning")
end sub

sub fsAttack()
   if not (uo.GetEasyUO(2) == "0") then 
      maDispell()
   end if
   if (uo.GetEasyUO(1) == "0") then
      uo.print("FS ATTACK MODE ON")
      uo.SetEasyUO(1,"1")
   else
      uo.print("FS ATTACK MODE OFF")
      uo.SetEasyUO(1,"0")
   end if 
end sub

sub maDispell()
   if not (uo.GetEasyUO(1) == "0") then 
      fsAttack()
   end if
   if (uo.GetEasyUO(2) == "0") then
      uo.print("DISPEL MODE ON")
      uo.SetEasyUO(2,"1")
   else
      uo.print("DISPEL MODE OFF")
      uo.SetEasyUO(2,"0")
   end if 
end sub

sub reflect()
   # 0x1F50
   Uo.print ("Curent target = "+uo.getname('Enemy'))
   uo.waittargetself()
   #uo.WaitTargetLast()
   if uo.count('0x1F50') then
      uo.usetype('0x1F50')
   else
      uo.cast('Magic Reflection','self')
   endif   
end sub

sub randomTarget()
   if (uo.GetEasyUO(3) == "0") then
      uo.print("RANDOM TARGET MODE ON")
      uo.SetEasyUO(3,"1")
   else
      uo.print("RANDOM TARGET MODE OFF")
      uo.SetEasyUO(3,"0")
   end if 
end sub

sub healpassive() ; Funcao q permite que você se heale, ao perder life, Usa-se Bandagens 
   UO.Set( 'injectecho', '1' )
   
   while NOT UO.Dead() 
      if (uo.GetEasyUO(1) == "1") then 
         uo.print(str(uo.GetEasyUO(1)))
         flamestike()
         wait(2400)
         lag()
         
      end if
      if (uo.GetEasyUO(3) == "1") then
         StartAttack0()
      end if
      if (uo.GetEasyUO(2) == "1") then
         magicarrow()
         wait(1500)
         lag()
         wait(20)
      end if
      #
      #if UO.InJournal('You are frozen and can not move.') then
      #   uo.print("Desparaliza")
      #   desparaliza() 
      #   wait(2000)
      #   uo.deletejournal()
      #end if
      if (Uo.Poisoned()) then 
         uo.print("Vou me curar !")
         curarse()
      end if
      if uo.mana < 30 then
         uo.print("MANA!")
         tomaMana();
      endif
      if (UO.Life < UO.str)  then 
         executaHeal()
         
         wait(200)
         #Armas1()
         #wait(3800)          
      end if
      
      if UO.Stamina < 10 then
         agilidade()
      endif 
      #loot()
      wait(20)
      #
   wend 
end sub 

sub debug()
   uo.info()
   uo.CancelMenu()
   #UO.showjournal(2)
   #uo.print(str(uo.prompt("???"))) 
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

sub desparaliza()
   if (uo.mana<4) then
      uo.usetype('0x0F02','0x0000')
   else
      uo.waittargettype('0x0F02','0x0000')
      uo.print("Saindo de paralize")
      uo.cast('Clumsy')
   end if
end sub

sub curarse()
   uo.usetype("0x0F0E","0x008F")
   uo.usetype("0x1F01")
   #wait(50)
   if uo.count("0x0F0E","0x008F")>0 then
      uo.print("Socorro !! bebendo potion de cura !")
      uo.usetype("0x0F0E","0x008F") 
   end if 
   wait(50)
   uo.usetype("0x1F03") 
end sub

sub testeDesp()
   uo.deletejournal()
   if UO.InJournal('You are frozen can not move.') then
      uo.print("Desparaliza")
      #desparaliza()
      wait(2000)
   end if
end sub



sub executaHeal()
   
   if (UO.Life < 30)  then
      if uo.count("0x0F82","0x017F")>0 then
         uo.print("Socorro !! bebendo potion")
         uo.usetype("0x0F82","0x017F")
      else
         uo.print("Aplicando bandage")
         UO.bandageself()
         wait(4800)
      end if  
   else
      uo.print("Aplicando bandage")
      UO.bandageself()
      wait(4800)
   end if
   
end sub

sub tomaMana()
   #if uo.mana < 20 then   
   uo.print("Mana boost : "+str(uo.count("0x0F82","0x0532")))
   uo.print("Refresh : "+str(uo.count("0x0F0E","0x0480")))
   if uo.mana < 40 and uo.mana > 10 then 
      if uo.count("0x0F0E","0x0480")>0 then
         uo.print("Tomando refresh")
         tomarTotalManaRefresh();
      else
         uo.print("Tomando Mana boost")
         tomarTotalManaRefiling();
      end if
   else
      if uo.count("0x0F82","0x0532")>0 then
         uo.print("Tomando Mana boost")
         tomarTotalManaRefiling();
      else
         if (uo.count("0x0F0E","0x0480") > 0) then 
            uo.print("Tomando refresh")
            tomarTotalManaRefresh();
         else
            meditar();
         end if
      end if
      
   end if
   #end if
end sub

sub meditar()
   
   var medit = 0	   
   uo.print("Meditando")  
   uo.Useskill('Meditation') 
   if UO.InJournal("You attempt a meditative trance") then
      medit=1
      uo.print("Medit OK !") 
   end if
   if UO.InJournal("Voce perdeu sua concentracao") then
      medit=0
      uo.print("Reiniciando a medit") 
   end if
   
end sub

sub agilidade()
   uo.usetype("0x0F0E","0x0022")
end sub

# >> ARROW NA EXPLOSION - DMN 


sub getEnemy()
   uo.getEnemy()
end sub

sub Arrow_Explodmn() 
   
   uo.waittargettype("0x0F0E","0x001E") 
   uo.cast("Magic Arrow") 
   
end sub

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


sub Armas1()
   Uo.print ("Curent target = "+uo.getname('Enemy')) 
   uo.waittargetobject('Enemy')
   #uo.useobject('a2')
   uo.useobject('a1')
   
   uo.attack ('Enemy') 
endsub

sub Armasoff()
   uo.msg(".disarm")
endsub

sub pegaTarget()
   uo.addobject("Enemy")
end sub

Sub paralize() 
   Uo.print ("Curent target = "+uo.getname('Enemy'))
   uo.waittargetobject('Enemy')
   #uo.WaitTargetLast()
   if uo.count('0x1F52') then
      uo.usetype('0x1F52')
   else
      uo.cast('Paralyze')
   endif
   uo.waittargetobject('Enemy')
   #uo.WaitTargetLast()
End Sub

Sub desmani() 
   Uo.print ("Curent target = "+uo.getname('Enemy'))
   uo.waittargetobject('Enemy')
   #if uo.count('0x1F4A') then
   #   uo.usetype('0x1F4A')
   #else
   uo.cast('Weaken')
   uo.waittargetobject('Enemy')
   #endif
End Sub

Sub lightning() 
   Uo.print ("Curent target = "+uo.getname('Enemy'))
   uo.waittargetobject('Enemy')
   if uo.count('0x1F4A') then
      uo.usetype('0x1F4A')
   else
      uo.cast('Lightning')
   endif
   uo.waittargetobject('Enemy')
   #uo.WaitTargetLast()
End Sub

Sub flamestike()
   Uo.print ("Curent target = "+uo.getname('Enemy'))
   uo.waittargetobject('Enemy')
   if uo.count('0x1F5F') then
      uo.usetype('0x1F5F')
   else
      uo.cast('Flame Strike')
   endif
   uo.waittargetobject('Enemy')
   #uo.WaitTargetLast()
End Sub

Sub clumsy() 
   Uo.print ("Curent target = "+uo.getname('Enemy'))
   uo.waittargetobject('Enemy')
   uo.cast('Clumsy')
End Sub


Sub magicarrow()
   Uo.print ("Curent target = "+uo.getname('Enemy'))  
   uo.waittargetobject('Enemy')
   if uo.count('0x1F32') then
      uo.usetype('0x1F32')
   else
      uo.cast('Magic Arrow')
   endif
   uo.waittargetobject('Enemy')
   #uo.waittargetobject('lastattack')
   #uo.WaitTargetLast()
   #uo.cast('')
End Sub

sub hidding()
   uo.findtype('0x0F0E','0x0631','my')
   if uo.findcount() and not uo.hidden() then
      uo.warmode(0)
      uo.useobject('finditem')
   endif
   if not uo.hidden() then
      uo.Useskill('Hiding') 
      wait(3500)
   end if 
   
end sub

sub tomarTotalManaRefresh()     
   uo.usetype(0x0F0E,0x0480)   
end sub

sub tomarTotalManaRefiling()     
   uo.usetype(0x0F82,0x0532)   
end sub

sub invis()
   uo.findtype('0x0F0E','0x0001')
   if uo.findcount() and not uo.hidden() then
      uo.warmode(0)
      uo.useobject('finditem')
   endif
endsub

sub sumcavalo()
   if uo.mana>24 then
      uo.waittargetobject('self')
      uo.waitmenu('What do you want to summon','Horse')
      uo.cast('Summ. Creature')
   else
      uo.print('No mana')
   endif
end sub


sub opendoor()
   uo.opendoor()
endsub


sub corpser()
   uo.waittargetobject('lastcorpse')
   uo.usetype('0x0F51')
   wait(500)
   Lootground()
   sword()
endsub
sub Lootground() 
   VAR n, f
   VAR Torso=uo.objatlayer('Torso')
   VAR Legs=uo.objatlayer('Legs')
   VAR Arms=uo.objatlayer('Arms')
   VAR Gloves=uo.objatlayer('Gloves')
   VAR Hat=uo.objatlayer('Hat')
   VAR Neck=uo.objatlayer('Neck')
   VAR Lhand=uo.objatlayer('Lhand')
   
   Dim Loot[40]
   Loot[1]='0x204E' ; Shroud
   Loot[2]='0x20D6' ; Dragon
   Loot[3]='0x0F5E' ; broadsword
   Loot[4]='0x143A' ; maul
   Loot[5]='0x13B9' ; Viking Sword
   Loot[6]='0x0F60' ; longsword
   Loot[7]='0x0F62' ; Spear
   Loot[8]='0x0E87' ; Pitchfork   
   Loot[9]='0x143E' ; Halberd
   Loot[10]='0x0F4D' ; Bardiche
   Loot[11]='0x0F45' ; Executioner's Axe
   Loot[12]='0x0F4B' ; double axe
   Loot[13]='0x13FA' ; Despise
   Loot[14]='0x13B1' ; Bow
   Loot[15]='0x0F4F' ; Heavy Crossbow
   Loot[16]='0x13FC' ; Crossbow
   Loot[17]='0x1086' ; Braclet
   Loot[18]='0x0EED' ; Gold Coin
   Loot[19]='0x13BF' ; chainmail tunic
   Loot[20]='0x13BE' ; chainmail leg
   
   Dim armor[12]
   armor[1]='0x1B77'  ; Heater Sheild
   armor[2]='0x1B76'  ; Heater Sheild
   armor[3]='0x1415'  ; Plate Mail
   armor[4]='0x1416'  ; Plate Mail
   armor[5]='0x141A'  ; Platemail Legs
   armor[6]='0x1411'  ; Platemail Legs
   armor[7]='0x1418'  ; Platemail Gauntlets
   armor[8]='0x1414'  ; Platemail Gauntlets
   armor[9]='0x1410'  ; Platemail Arms
   armor[10]='0x1419' ; Platemail Helm
   armor[11]='0x1412' ; Platemail Helm
   armor[12]='0x1413' ; Platemail Gorget
   
   for n=1 to 12
      if uo.countground(armor[n]) then
         uo.usefromground(armor[n])
         wait(50)
         f=1
      endif
   next
   for n=1 to 20
      if uo.countground(Loot[n]) then
         uo.moveitem('~'+Loot[n],0,'backpack')
         wait(700)
      endif
   next
   if f==1 then
      if Torso<>'' then
         uo.useobject(Torso)
      endif
      if Legs<>'' then
         uo.useobject(Legs)
      endif
      if Arms<>'' then
         uo.useobject(Arms)
      endif
      if Gloves<>'' then
         uo.useobject(Gloves)
      endif
      if Hat<>'' then
         uo.useobject(Hat)
      endif
      if Neck<>'' then
         uo.useobject(Neck)
      endif
      if Lhand<>'' then
         uo.equip('Lhand',Lhand)
      endif
   endif
   uo.print(' -= done =- ')
endsub

#++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
#++++++++++++++-= Auto Attack Men\Women =-++++++++++++++++ 
#++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 

#+++++++++++++-= Auto Attack qualquer player =-+++++++++++++++ 
sub StartAttack1() ;?????? ??? ????? ???? ????? 
   StartAttack(1) 
end sub 
#++++++++++-= Auto Attack PK players =-+++++++++++++++ 
sub StartAttack0() ;?????? ??? ????? ?????? ??,????? ? ????????????? ??????? 
   var totalFriend=20
   var temp, name, i, t = 0, k, a, findResult = 0
   DIM friend[21]
   Friend[0]="CoMpLeX" 
   Friend[1]="Bashar" 
   Friend[2]="GHZATOMIC" 
   Friend[3]="Mary Ann" 
   Friend[4]="SuDa" 
   Friend[5]="Tio Ryze"
   Friend[6]="O Apostolo"
   Friend[7]="Batatao" 
   Friend[8]="MarlborO"
   Friend[9]="KorteZ"
   Friend[10]="Pandox"
   Friend[11]="DemoniC"
   Friend[12]= "Killer"#"The Sexy"
   Friend[13]="Rasmus"
   Friend[14]="PrOoF"
   Friend[15]="bLooD"
   Friend[16]="Dona Veneranda"
   Friend[17]="Kahllesh"
   Friend[18]="And Now"
   #Friend[11]="KorteZ"
   
   DIM b[4]
   b[1] = '0x0190'
   b[2] = '0x0191'
   #b[3] = 'IS'
   
   uo.set('finddistance','13')
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
               #uo.addobject('laststatus',a)
               #uo.addobject('lasttarget',a)
               uo.addobject('Enemy',uo.getserial("finditem"))
               uo.getStatus("finditem")
               Uo.print ("Target = "+uo.getname('Enemy'))
               #Uo.print (".")
               Uo.say(".gc [Target] "+uo.getname('Enemy'))
               uo.ignore('finditem')
               #if uo.getnotoriety('finditem')>= 1 then
               #uo.cast('Magic Arrow',a)
               #wait(100)
               #uo.attack(a)
               #end if
               return false
            end if
         until findResult == 0
         if findResult == 0 then
            uo.IgnoreReset()
         end if
      next
      uo.print('Ngm na area')
end sub 


sub organiza()
   uo.exec(",massmove 500")
end sub


sub buy() ## mod from Dearhell's script
   VAR buyListName='nightshade' ##change per buy list
   Dim vendorType[2]
   vendorType[1]='0x0190'
   vendorType[2]='0x0191'
   VAR x
   
   For x=1 to 2
      UO.Exec("set finddistance 3")
      UO.FindType(vendorType[x],"-1",'ground')
      UO.GetName('finditem')
      If (UO.GetName('finditem')==UO.GetName()) then
         UO.Print('We delete the character name from the search list')
         UO.Ignore('finditem')
         UO.FindType(vendorType[x],"-1",'ground')
         wait(500)
      endIf
      if UO.FindCount()>0 then
         UO.Print('We buy regs from -> '+UO.GetName('finditem'))
         wait(500)
         UO.Say('Hi '+UO.GetName('finditem'))
         wait(500)
         UO.Buy(buyListName,UO.GetName('finditem'))
         wait(500)
         UO.Ignore('finditem')
      EndIf
   next
   UO.Exec("set finddistance 10")
   UO.Ignorereset()
end sub


sub target()
   UO.FindType("0x1543")
   var list = VendorList()
   uo.print(list.Count())
   ;uo.buy("Skullcap")
end sub

sub target2()
   var list = uo.GetShopList() #??????? ????????? ???? ?? ???????
   
   
   if not list.InClient() then
      uo.print('???? ??????? ??? ????????? ????????/????????.')
      return
   endif
   
   uo.sell(list.ItemName(1))
   uo.print(str(list.ItemName(1)))
   uo.print(str(list.ItemColor(1)))
   
end sub

sub testshop2()
   uo.msg('bye')
   wait(500)
   uo.msg('buy')
   wait(500)
   
   var BuyItemsCount = 8 
   var BuyDelay = 300 
   
   dim BuyType[20], BuyColor[20], BuyCount[20]
   
   #1:
   BuyType[0] = 'bm' 
   BuyColor[0] = 0
   BuyCount[0] = 50 
   
   #2:
   BuyType[1] = 'bp'
   BuyColor[1] = 0
   BuyCount[1] = 50
   
   # 3:
   BuyType[2] = 'ga'
   BuyColor[2] = 0
   BuyCount[2] = 50
   
   BuyType[3] = 'gs'
   BuyColor[3] = 0
   BuyCount[3] = 50
   
   BuyType[4] = 'mr'
   BuyColor[4] = 0
   BuyCount[4] = 50
   
   BuyType[5] = 'ns'
   BuyColor[5] = 0
   BuyCount[5] = 50
   
   BuyType[6] = 'sa'
   BuyColor[6] = 0
   BuyCount[6] = 50
   
   BuyType[7] = 'ss'
   BuyColor[7] = 0
   BuyCount[7] = 50
   
   if BuyItemsCount < 1 then
      uo.print('Pouco Item ....')
      return
   endif
   
   var list = uo.GetShopList() #
   
   if not list.IsBuyList() then
      uo.print('Não é compra.')
      return
   endif
   
   if not list.InClient() then
      uo.print('Lista nao ta no client.')
      return
   endif
   
   var i = 0, j = 0, ReplyCount = 0, want = 0, count = list.Count()
   
   if count then
      count = count - 1
      
      var reply = VendorReply(list.Serial(), BuyItemsCount) #
      
      BuyItemsCount = BuyItemsCount - 1
      
      for i = 0 to count
         for j = 0 to BuyItemsCount
            
            want = BuyCount[j] - uo.Count(BuyType[j], BuyColor[j])
            
            if want > 0 && list.ItemGraphic(i) == uo.GetGraphic(BuyType[j]) then
               if BuyColor[j] == -1 || list.ItemColor(i) == uo.GetGraphic(BuyColor[j]) then
                  
                  if want > list.ItemCount(i) then
                     want = list.ItemCount(i)
                  endif
                  
                  if want > 0 then #
                     reply.ItemSerial(ReplyCount, list.ItemSerial(i))
                     reply.ItemCount(ReplyCount, want)
                     
                     ReplyCount = ReplyCount + 1
                  endif
               endif
            endif
         next
      next
      
      if ReplyCount then
         uo.print('ReplyCount = ' + str(ReplyCount) + ' waiting ' + str(BuyDelay * ReplyCount) + ' ms')
         wait(BuyDelay * ReplyCount)
         
         reply.Count(ReplyCount) 
         uo.SendShopReply(reply) 
      else
         uo.print('Nao montou o protocolo de compra')
      endif
   else
      uo.print('Nao vai comprar nada')
   endif
end sub

sub fazerPotionMana()
   
   uo.Automenu('Alchemy Menu',"Total Mana Refresh") 
   uo.usetype("WUF") 
   UO.FindType('LZF','-1','my')
   uo.waittargetobject('finditem')
   
   
end sub

sub traking()
   
   uo.waitmenu('Tracking','Anything')
   uo.useskill('Tracking')
   
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

#Função do macro:
#1- Fazer algum item e devolve-lo a uma Bag.
#2- Voce escolhe quantos items deseja fazer

#O que é necessário ter in-game para o macro rodar:
#Na macro:
#-Escolher quantos items deseja fazer, onde esta em negrito:
#var i,x=15
#-Ajustar o Type do item que voce ira fazer, onde esta em negrito:
#uo.findtype('0x1BC3',-1,'my') #Chaos
#*Digite ,info no item para descobrir o Type.
#
#Ingame:
#- Estar ao lado de uma Forge.
#- Estar com um Smith Hammer na mao.
#- Colocar os Ingots em algum continer
#- Abrir o container onde estão os Ingots
#*(É NECESSÁRIO QUE ESTE SEJA O ULTIMO CONTAINER A SER ABERTO ANTES DE COMEÇAR A MACRO)
#- Fazer 1 vez o item que deseja fazer.
#- Digitar ,exec bs

sub bs()
   var i,x=5
   repeat
      uo.deletejournal()
      if uo.count('0x1BEF')<35 then
         UO.FindType('0x1BEF','-1','lastcontainer')
         repeat
            UO.Grab('300','finditem')
            wait(10)
         until uo.count('0x1BEF')>35
      endif
      uo.usetype('0x1BEF')
      repeat
         wait(5)
      until uo.lastgump( 'replyed' ) == 0 and uo.lastgump( 'text', 4 ) == 'Platemail'
      uo.lclick(320,443)
      repeat
         wait(1)
      until uo.injournal('Voce falhou|Voce pos')
      if uo.injournal('Voce pos') then
         x=x-1
         uo.findtype('0x1415',-1,'my') #Plate iron
         uo.moveitem('finditem', '0', 'lastcontainer')
      endif
   until x==0
endsub

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


sub Ress()
   var i 
   Dim a[2] 
   a[1] = '0x0192' 
   a[2] = '0x0193' 
   UO.Set('finddistance','2') 
   For i= 1 to 2 
      uo.findtype(a[i], -1, 'ground') 
      if uo.findcount() then 
         uo.waittargetobject('finditem') 
         uo.usetype('0x0E21')
         #uo.cast('Resurrection') ; ress
      else 
         uo.print('ghost not found') 
      end if 
   Next 
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
   
   uo.say(".recall 1 2")
   uo.warmode(0) 
   wait(1000) 
   #invis(); 
   uo.Print('Recalando, NAO SE MECHA.') 
   uo.Print('Recalando, NAO SE MECHA.') 
   uo.Print('Recalando, NAO SE MECHA.') 
   
end sub 

sub loot() ;
   var i,n 
   Dim A[36] 
   A[1] = 0x1F5F ;Flame Strike Scroll 
   A[2] = 0x0F82 ;Mana Boost
   A[3] = 0x0E76 ;BANDS
   A[4] = 0x0F82 ;Peito 2
   A[5] = 0x1411 ;Legs
   A[6] = 0x141A ;Legs 2
   A[7] = 0x1410 ;Arms
   A[8] = 0x1417 ;Arms 2
   A[9] = 0x1414 ;Gloves
   A[10] = 0x1418 ;Gloves
   A[11] = 0x1413 ;Gorget
   A[12] = 0x1F5F ;Peito
   A[13] = 0x1545 ;Bear Mask
   A[14] = 0x1546 ;bear nova
   A[15] = 0x0E76 ;Anel
   A[16] = 0x0F82 ;pocao normal
   A[17] = 0x0EED ;robe
   A[18] = 0x0ef0 ;GOLD
   A[19] = 0x175D ;pano 
   A[20] = 0x0E76 ;Bag
   A[21] = 0x0F86 ;MR
   A[22] = 0x0F84 ;GARLIC
   A[23] = 0x0F0E ;order 2
   A[24] = 0x1BC3 ;chaos
   A[25] = 'AL1' ;item 1 
   A[26] = 'AL2' ;item 2 
   A[27] = 'AL3' ;item 3 
   A[28] = 'AL4' ;item 4 
   A[29] = 'AL5' ;item 5 
   A[30] = 'AL6' ;item 6 
   A[31] = 'AL7' ;item 7 
   A[32] = 'AL8' ;item 8 
   A[33] = 'AL9' ;item 9 
   A[34] = 'AL10' ;item 10 
   A[35] = 'AL11' ;item 11 
   A[36] = 'AL12' ;item 12 
   i = 1700
   FOR n=1 TO 36
      uo.findtype(A[n],"-1","lastcorpse") 
      if uo.findcount() > 0 then
         UO.grab(0,"finditem") 
         Wait(i) 
      end if 
   NEXT 
   uo.print("CONCLUIDO!") 
end sub

sub Auto_Loot_Chao() 
   
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


