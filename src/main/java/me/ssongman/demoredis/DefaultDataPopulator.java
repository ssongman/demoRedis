package me.ssongman.demoredis;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultDataPopulator implements ApplicationRunner {
	
	@Autowired 
	MeetingRepository meetingRepository;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Meeting meeting = new Meeting();
		meeting.setTitle("New Meeting");
		meeting.setStartAt(new Date());
		meetingRepository.save(meeting);

		System.out.println("========================");
		meetingRepository.findAll().forEach(m -> {
			System.out.println(m.getId() + " | " + m.getTitle() + " | " + m.getStartAt());
		});
		
	}

}
