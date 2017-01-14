package intro.algorithms.greedy;

import static org.junit.Assert.*;

import org.junit.Test;

import intro.algorithms.greedy.ActivitySelection.ActivitySelectionSolution;

public class ActivitySelectionTest {

	@Test
	public void testSelectActivities() {
		ActivitySelection.Activity[] activities = new ActivitySelection.Activity[11];
		activities[0] = new ActivitySelection.Activity(5, 9);
		activities[1] = new ActivitySelection.Activity(8, 12);
		activities[2] = new ActivitySelection.Activity(3, 5);
		activities[3] = new ActivitySelection.Activity(12, 16);
		activities[4] = new ActivitySelection.Activity(3, 9);
		activities[5] = new ActivitySelection.Activity(1, 4);
		activities[6] = new ActivitySelection.Activity(8, 11);
		activities[7] = new ActivitySelection.Activity(0, 6);
		activities[8] = new ActivitySelection.Activity(2, 14);
		activities[9] = new ActivitySelection.Activity(5, 7);
		activities[10] = new ActivitySelection.Activity(6, 10);
		
		ActivitySelection selection = new ActivitySelection();
		
		ActivitySelectionSolution solution = selection.selectActivities(activities);
		System.out.println("count: "+solution.getCount()+", activities:");
		for(ActivitySelection.Activity activity : solution.getActivities()) {
			System.out.println("start: "+activity.getStart()+", end: "+activity.getEnd());
		}
	}

}
