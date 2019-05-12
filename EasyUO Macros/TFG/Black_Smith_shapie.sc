sub BlackSmith()
   var Iron = '0x1BEF'
   var Item = '0x1BD7'
   uo.print('Bau que vai ter os irons:')
   uo.addobject('Bau')
   while UO.Targeting()
      wait(100)
   wend
   wait(500)
   repeat
      If uo.count(Iron) < 10 then
         uo.findtype(Iron,"-1","Bau") 
         uo.grab('2500','finditem')
         Wait(500)
      EndIf
      If uo.count(Item) > 50 then 
         uo.findtype(Item,"-1","backpack") 
         uo.moveitem('finditem','all','Bau') 
         wait(500) 
      EndIf
      uo.waitmenu('Blacksmithing','Shaped Iron (5 iron ingots)')
      uo.usetype(Iron)
      
      repeat
         wait(100)
      until uo.injournal('Voce falhou|You put the')
      uo.DeleteJournal()
   until uo.count(Iron) <= 2
End Sub