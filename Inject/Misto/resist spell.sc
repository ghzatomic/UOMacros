var INIMIGO = 0;

sub main()
   while NOT UO.Dead()
      if UO.Mana < 10 then
         uo.deletejournal();
         while UO.Mana < UO.int
           verificaManaETomaPotionOuMedita()
           wait(1000)
         wend
      else
         manaDrain()
      end if
      wait(4100)
   wend
end sub

sub verificaManaETomaPotionOuMedita()
   if UO.Mana < 10 then
      If UO.Count('0x0f0e','0x0480')>0 then
         UO.UseType('0x0f0e','0x0480');
      Else  
         UO.UseSkill('Meditation')
      End If
   end if
end sub

sub marcaTarget();
   var eu =0;
   
   eu = uo.getserial('self');
   UO.AddObject ('INIMIGO')
   While UO.Targeting()
      Wait(100)
   Wend
   INIMIGO =  uo.getserial('INIMIGO');
   
   ;uo.useobject(INIMIGO);
end Sub

sub manaDrain() 
   var  objInimigo = uo.getserial('INIMIGO');
   ; verificaManaETomaPotionOuMedita();
   uo.cast('Mana Drain',objInimigo);
end sub