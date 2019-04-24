package day0416;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class SecureRandomNumbers {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		SecureRandom secure = SecureRandom.getInstance("SHA1PRNG", "SUN");
		byte[] random = new byte[128];
		secure.nextBytes(random);
		int x = secure.nextInt();
		
		int randomInRange = secure.nextInt(9999999);
		System.out.println(randomInRange);
		
		LocalDate dat = LocalDate.of(2019, 04, 10);
		LocalDate now = LocalDate.now();
		Period difference = Period.between(dat, now);
		System.out.printf("Difference is %d years, %d months and  %d days old", difference.getYears(), difference.getMonths(), difference.getDays());
		difference.getYears();
		difference.getMonths();
		difference.getDays();
		long diffinDays = ChronoUnit.MONTHS.between(dat, now);
	}

}
