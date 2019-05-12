

sub teste()
   
   #uo.print(str(uo.mana))
   uo.info()
   
end sub
sub fzBlankScroll()
   uo.CancelMenu()
   uo.Automenu('Carpentry',"blank scroll")
   uo.Automenu("Blank Scrolls","10 blank scroll") 
   var log = '0x1BDD'
   while NOT UO.Dead()
      uo.deletejournal()
      uo.usetype('0x1034')
      wait(2300)  
      Guardarscrool()
      UO.FindType(log,'0x0000',"my")
      wait(100)
      if (uo.findcount() < 1) then
         uo.print("Pegando logs ...")
         pegaLog()         
      end if
   wend
   
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

sub Guardarscrool()
   var n
   var scroll = '0x0E34'
   if (uo.count(scroll) >= 1000) then 
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
   end if
end sub

