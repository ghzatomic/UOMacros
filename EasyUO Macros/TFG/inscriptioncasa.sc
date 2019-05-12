sub insc()
   UO.Print('Macro de Inscription para TFGShard iniciado')
   UO.Print('Selecione a bag aonde estao os blank scrolls')
   UO.AddObject('blankscrolls')
   While UO.Targeting()
      Wait(1000)
   Wend
   UO.Print('Selecione a bag aonde serao guardados os scrolls prontos')
   UO.AddObject('scrollsprontos')
   While UO.Targeting()
      Wait(1000)
   Wend
   VAR LastTimer
   VAR WaitTime=200
   
   inicio:
   LastTimer=UO.Timer()
   if UO.Count('0x0E34','0x0000') < 2 then
      UO.UseObject('blankscrolls')
      Wait(200)
      UO.FindType('0x0E34','0x0000','blankscrolls')
      UO.MoveItem('finditem',2000,'my')
      Wait(500)
   end if
   UO.WaitMenu('Spell','Seventh','Spell','Flamestrike')
   UO.UseType('0x0E34','0x0000')
   Wait(1000)
   UO.DeleteJournal()
   repeat
      Wait(100)
   until UO.InJournal("You have failed") OR UO.InJournal("You fail") OR UO.InJournal("Voce falhou") OR UO.InJournal("You put") OR UO.InJournal("Skill") OR UO.InJournal("You have no") OR LastTimer+WaitTime<UO.Timer()
   UO.Print("Blank: "+str(UO.Count('0x0E34','0x0000'))+" - Feito: "+str(UO.Count('0x1F5F','0x0000'))+" - Ganho: "+str(UO.SkillVal('Inscription',2)))
   if Uo.Mana < 40 then
      repeat
         UO.UseSkill( 'Meditation' ) 
         wait(2000) 
      Until UO.Mana >= 150
   end if
   if UO.Count('0x1F5F','0x0000') > 20 then
      guardar()
   end if
   goto inicio
end sub
sub guardar()
   While UO.Count('0x1F5F','0x0000') > 0
      UO.FindType('0x1F5F','0x0000','my')
      UO.MoveItem('finditem',-1,'scrollsprontos')
      Wait(500)
   Wend
end sub