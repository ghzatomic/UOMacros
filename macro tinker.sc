

sub teste()
   uo.info()
   #uo.useobject('UVEQLMD')
end sub

sub pegarIron()
   var iron = '0x1BEF'
   var container = "UVEQLMD"
   if (uo.count(iron) == 0) then 
      uo.msg('banker bank')
      wait(1000)
      uo.useobject(container)
      wait(1000)
      UO.FindType(iron,"0x0000","lastcontainer")
      uo.moveitem('finditem', '300', 'backpack')
   end if
end sub

sub macroTinker() 
   uo.CancelMenu()
   uo.Automenu('Tinkering',"Parts")
   uo.Automenu("Parts","gears") 
   while NOT UO.Dead()
      pegarIron()
      uo.useobject("MUQZKMD")
      wait(3000)
      GuardarTinker()
   wend
   
end sub


sub GuardarTinker()
   var n
   var scroll = '0x1053'
   if (uo.count(scroll) >= 50) then 
      uo.msg('banker bank')
      wait(1000)
      uo.useobject('GWOJMMD')
      
      while uo.count(scroll) >= 1
         wait(1300)
         UO.FindType(scroll,'-1')
         uo.moveitem('finditem', '0', 'GWOJMMD')
      wend
   end if
end sub

