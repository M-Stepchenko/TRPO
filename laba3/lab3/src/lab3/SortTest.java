package lab3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SortTest {
	double[] array = {-8.12, 4, 15, -70.3, 90, 40.1, 5.09, 4.01};
	
	@Test
	public void testFindMinElem() {
		double expected = -70.3;
		double result = Main.findMinElem(array);
		
		Assert.assertEquals(result, expected, 0.001);
	}
	
	@Test
	public void testFindMaxElem() {
		double expected = 90;
		double result = Main.findMaxElem(array);
		
		Assert.assertEquals(result, expected, 0.001);
	}
	
	@Test
	public void testIntersionSort() {
		double[] expected = {-70.3, -8.12, 4, 4.01, 5.09, 15, 40.1, 90};
		double[] result = Main.insertionSort(array);
		
		for (int i = 0; i < array.length; i++)
		{
			Assert.assertEquals(result[i], expected[i], 0.001);
		}
	}

	@Test
	public void testBucketSort() {
		double[] expected = {-70.3, -8.12, 4, 4.01, 5.09, 15, 40.1, 90};
		double[] result = Main.bucketSort(array, 5);
		
		for (int i = 0; i < array.length; i++)
		{
			Assert.assertEquals(result[i], expected[i], 0.001);
		}
	}
}