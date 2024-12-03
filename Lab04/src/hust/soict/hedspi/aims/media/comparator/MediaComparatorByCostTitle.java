package hust.soict.hedspi.aims.media.comparator;

import java.util.Comparator;

import hust.soict.hedspi.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		Media m1 = (Media) o1 , m2 = (Media) o2;
		float cost1 = m1.getCost(), cost2 = m2.getCost();
		
		if (cost1 < cost2) return -1;
		if (cost1 > cost2) return 1;
		if (cost1 == cost2) {
			String title1 = m1.getTitle(), title2 = m2.getTitle();
			return title1.compareTo(title2);
		}
		return 0;
	}

}
