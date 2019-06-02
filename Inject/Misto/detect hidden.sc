var INIMIGO = 0;

sub main()
   var  objInimigo = uo.getserial('INIMIGO');
   while NOT UO.Dead()
      uo.warmode(0)
      UO.UseSkill("Detect Hidden")
      wait(1500)
      if (UO.SkillVal( 'Anatomy' ) < 1028)then 
        uo.warmode(0)
        UO.Set('lasttarget',objInimigo)
        UO.Exec("waittargetlast") 
        UO.UseSkill("Anatomy")
        wait(150)
        #uo.useobject("0x0190");
        wait(1500)
      end if
      if (UO.SkillVal( 'Forensic Evaluation' ) > 1028)then
        uo.warmode(0) 
        UO.UseSkill("Forensic Evaluation")
        wait(150)
        UO.Exec("waittargetlast")
        #uo.useobject(INIMIGO);
        wait(1500)
      end if 
      if (UO.SkillVal( 'Item Identification' ) < 1028)then
        uo.warmode(0)
        #uo.addtarget() 
        uo.findtype('0x0EFA',-1,'my')
         if uo.findcount() then
            uo.waittargetobject('finditem')
            UO.UseSkill("Item Identification")
         endif
        #UO.Exec("waittargetlast")
        #uo.useobject("");
        wait(1800)
      end if 
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