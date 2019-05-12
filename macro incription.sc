

sub teste()
    uo.info()
   #var elem1 = '0x0E34'
   #var elem2 = '0x0F8D'
   #var elem3 = '0x0F86'
   #var elem4 = '0x0F84'
   #var container = "NFZNMMD"
   
   #uo.useobject(container)
   #uo.print(str(uo.count(elem1,"0x0000","lastcontainer")))
end sub
sub fzScroll()
   uo.CancelMenu()
   wait(1000)
   uo.Automenu('Spell Circles',"Seven")
   uo.Automenu("Spell Circle 7","Flame") 
   var medit=0
   while NOT UO.Dead()
      uo.deletejournal()
      #pegarElementos()
      while (uo.mana>20)
         medit = 0
         if (uo.count("0x0E34") == 0) then 
            pegarElementos()
         else
            uo.usetype('0x0E34')
            wait(2300)  
         end if
         
      wend
      while NOT (  uo.mana == 100)
         uo.deletejournal() 
         if medit == 0 then 
            uo.print("Meditando")  
            uo.Useskill('Meditation')
            wait(3000)
         end if
         if UO.InJournal("You attempt a meditative trance") then
            medit=1
            uo.print("Medit OK !") 
         end if
         if UO.InJournal("Voce perdeu sua concentracao") then
            medit=0
            uo.print("Reiniciando a medit") 
         end if
         if UO.InJournal("You stop concentrating.") then
            medit=0
            uo.print("Reiniciando a medit") 
         end if
         Guardarscrool()
         wait(200)
      wend 
   wend
   
end sub

sub pegarElementos()
   var elem1 = '0x0E34'
   var elem2 = '0x0F8D'
   var elem3 = '0x0F8C'
   var container = "NFZNMMD"
   if (uo.count(elem1) == 0) then 
      uo.msg('banker bank')
      wait(1000)
      uo.useobject(container)
      wait(200)
      #uo.print(str(uo.count(elem1,"0x0000","lastcontainer")))
      #if uo.count(elem1,"0x0000","lastcontainer") == 0 then 
      #uo.print("Aqui")
      #wait(5000)
      #   fzBlankScroll(1000)
      #end if 
      uo.msg('banker bank')
      wait(1000)
      uo.useobject(container)
      wait(1000)
      UO.FindType(elem1,"0x0000","lastcontainer")
      uo.moveitem('finditem', '300', 'backpack')
      wait(1000)
      UO.FindType(elem2,"0x0000","lastcontainer")
      uo.moveitem('finditem', '300', 'backpack')
      wait(1000)
      UO.FindType(elem3,"0x0000","lastcontainer")
      uo.moveitem('finditem', '300', 'backpack')
      wait(1000)
   end if
end sub

sub Guardarscrool()
   var n
   var scroll = '0x1F5F'
   if (uo.count(scroll) >= 1) then 
      uo.msg('banker bank')
      wait(1000)
      uo.useobject('NFZNMMD')
      
      while uo.count(scroll) >= 1
         wait(1600)
         UO.FindType(scroll,'-1')
         uo.moveitem('finditem', '0', 'NFZNMMD')
      wend
   end if
   
end sub




sub fzBlankScroll()
   var qtde = 1000
   #uo.CancelMenu()
   #wait(1000)
   uo.Automenu('Carpentry',"blank scroll")
   uo.Automenu("Blank Scrolls","10 blank scroll") 
   var log = '0x1BDD'
   var indice = 0
   while NOT indice > qtde 
      uo.deletejournal()
      uo.usetype('0x1034')
      wait(2300)  
      UO.FindType(log,'0x0000',"my")
      wait(100)
      if (uo.findcount() < 1) then
         uo.print("Pegando logs ...")
         pegaLog()         
      end if
      indice = indice+1
   wend
   Guardarbscrool()
end sub


sub pegaLog()
   var log = '0x1BDD'
   var containerDoLog = "OVEQLMD"
   uo.msg('banker bank')
   wait(1000)                                       
   uo.useobject(containerDoLog)
   wait(1000)
   UO.FindType(log,'0x0000',"lastcontainer")    
   uo.print(str(uo.findcount()))      
   if (uo.findcount() >= 1) then
      uo.moveitem('finditem', '1000', 'my')
      wait(200)
   end if
   
end sub

sub Guardarbscrool()
   var n
   var scroll = '0x0E34'
   uo.print("Guardando scroll")
   if (uo.count(scroll) >= 1) then 
      uo.msg('banker bank')
      wait(1000)
      uo.useobject('NFZNMMD')
      
      while uo.count(scroll) >= 1
         wait(1600)
         UO.FindType(scroll,'-1')
         uo.moveitem('finditem', '0', 'NFZNMMD')
      wend
   end if
end sub


