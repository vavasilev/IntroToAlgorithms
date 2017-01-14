package amazonprep.algorithms.greedy;

import java.util.Arrays;

import amazonprep.algorithms.sort.QuickSort;
import amazonprep.algorithms.sort.Sortable;

public class ActivitySelection {
	
	public ActivitySelectionSolution selectActivities(Activity [] activities) {
		QuickSort<Integer, Activity> qs = new QuickSort<Integer, Activity>();
		Activity [] sortedActivities = qs.sort(activities);
		Activity [] result = new Activity[activities.length];
		
		int j=0;
		int lastFinishTime = 0;
		for(int i=0; i < sortedActivities.length; i++) {
			if(sortedActivities[i].start >= lastFinishTime) {
				result[j] = sortedActivities[i];
				j++;
				lastFinishTime = sortedActivities[i].end;
			}
		}
		return new ActivitySelectionSolution(j, Arrays.copyOf(result, j));
	}
	
	public static class ActivitySelectionSolution {
		private int count;
		private Activity [] activities;
		public ActivitySelectionSolution(int count, Activity[] activities) {
			super();
			this.count = count;
			this.activities = activities;
		}
		public int getCount() {
			return count;
		}
		public Activity[] getActivities() {
			return activities;
		}
	}
	
	public static class Activity implements Sortable<Integer> {
		private int start;
		private int end;
		public Activity(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		public int getStart() {
			return start;
		}
		public int getEnd() {
			return end;
		}
		@Override
		public Integer getKey() {
			return end;
		}
		@Override
		public void setKey(Integer key) {
			this.end = key;
		}
	}
}
