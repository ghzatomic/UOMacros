sub Fishing()
	var now_x
	var now_y
	var last_x
	var last_y
	var target_x
	var target_y
	
		UO.DeleteJournal()
		UO.Say("forward")
		while NOT UO.InJournal("Aye")
			wait(300)
		wend
		while UO.SkillVal("Fishing",1) < 1000
			
			now_x = UO.GetX()
			now_y = UO.GetY()
			target_x = now_x + 3
			target_y = now_y - 3
			if now_x == last_x AND now_y == last_y then
				UO.DeleteJournal()
				UO.Say("turn right")
				while NOT UO.InJournal("Aye")
					wait(300)
				wend
				UO.DeleteJournal()
				UO.Say("forward")
				while NOT UO.InJournal("Aye")
					wait(300)
				wend
			end if
			UO.DeleteJournal()
			UO.WaitTargetTile("0",STR(target_x),STR(target_y),"251")
			UO.UseType('0x0DBF') #fishing pole
			while NOT UO.InJournal("You pull out a nice fish") AND NOT UO.InJournal("You fish a while, but fail to catch anything") AND NOT UO.InJournal("There are no fish here") AND NOT UO.InJournal("That is too far away") AND NOT UO.InJournal("Try fishing in water")
				wait(300)
			wend
			last_x = now_x
			last_y = now_y
		wend

end sub