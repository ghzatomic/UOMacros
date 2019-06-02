

sub teste()
   uo.sell("vendorParts")
end sub

sub macroTinker() 
   uo.CancelMenu()
   uo.Automenu('Tinkering',"Parts")
   uo.Automenu("Parts","clock parts") 
   while NOT UO.Dead()
      pegarIron()
      uo.useobject("MUQZKMD")
      wait(3000)
      GuardarTinker()
   wend
   
end sub

sub macroVenderMinoc()  
   var parts = '0x104F'
   var container = "GWOJMMD"
   while not uo.dead()
   Caminhar(2494,546,0)
      if (uo.count(parts) <= 2) then 
         uo.msg('banker bank')
         wait(1000)
         uo.useobject(container)
         wait(1000)
         UO.FindType(parts,"0x0000","lastcontainer")
         uo.moveitem('finditem', '210', 'backpack')
      end if   
      
      Caminhar(2490,516,0)
      Caminhar(2489,483,0)
      Caminhar(2504,483,0)
      Caminhar(2504,436,0)
      uo.msg('.open_door')
      uo.msg('.open_door')
      Caminhar(2502,433,0)
      
      UO.Print('We sell regs from -> '+UO.GetName('finditem'))
      wait(500)
      UO.Say('Hi '+UO.GetName('finditem'))
      wait(500)
      uo.print("Comprando")
      wait(10000)
      wait(2000)
      wait(500)
      UO.Ignore('finditem')
      Caminhar(2504,433,0)
      Caminhar(2504,437,0)
      uo.msg('.open_door')
      uo.msg('.open_door')
      Caminhar(2504,484,0)
      Caminhar(2490,516,0)
      Caminhar(2494,546,0) 
   wend
end sub

sub pegarIron()
   var iron = '0x1BEF'
   var container = "UVEQLMD"
   if (uo.count(iron) <= 2) then 
      uo.msg('banker bank')
      wait(1000)
      uo.useobject(container)
      wait(1000)
      UO.FindType(iron,"0x0000","lastcontainer")
      uo.moveitem('finditem', '300', 'backpack')
   end if
end sub




sub GuardarTinker()
   var n
   var scroll = '0x104F'
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

Sub Caminhar(x,y,dist)
   uo.print("Movendo para : "+str(x)+","+str(y))
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
         Wait(50)
      Else
         dir=UO.Random(8)
         For loop=0 to UO.Random(5)+2
            UO.Press(Anda[dir])
            Wait(50)
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
