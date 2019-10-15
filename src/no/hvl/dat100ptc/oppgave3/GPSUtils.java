package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double latitude[] = new double[gpspoints.length];
		int i;
		for (i = 0; i < gpspoints.length; i++) {
			latitude[i] = gpspoints[i].getLatitude();
		}
		return latitude;
		
		
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double longitude[] = new double[gpspoints.length];
		int i;
		for (i = 0; i < gpspoints.length; i++) {
			longitude[i] = gpspoints[i].getLongitude();
		}
		return longitude;

		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		
		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		double deltaLat = latitude2 - latitude1;
		double deltaLong = longitude2 - longitude1;
		double a = Math.pow((Math.sin(deltaLat/2)), 2) + (Math.cos(latitude1)*Math.cos(latitude2)*Math.pow(Math.sin(deltaLong/2), 2));
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		d = R * c;
		
		return d;
 
		// TODO - START

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		speed = distance(gpspoint1, gpspoint2)/secs;
		
		return speed * 3.6;
		

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		int hour = secs/(60*60);
		String hr = String.format("%02d", hour);
		int min = (secs - hour*60*60)/60;
		String minutes = String.format("%02d", min);
		int sec = secs - hour*60*60 - min*60;
		String seconds = String.format("%02d", sec);
		
		timestr = hr + TIMESEP + minutes + TIMESEP + seconds;
		return String.format("%10s", timestr);
			
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START
		str = String.format("%.2f", d);
		return String.format("%" + TEXTWIDTH + "s", str).replace(',', '.');

		
		// TODO - SLUTT
		
	}
}
