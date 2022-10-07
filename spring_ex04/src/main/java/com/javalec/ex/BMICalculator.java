package com.javalec.ex;

public class BMICalculator {
	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;
	
	public void bmicalculation(double weight, double height) {
		double h = height * 0.01;
		double result = weight / (h*h);
		
		System.out.println("BMI ���� : " + (int)result);
		
		if(result > obesity) {
			System.out.println("���Դϴ�.");
		} else if(result > overWeight) {
			System.out.println("��ü���Դϴ�.");
		} else if(result > normal) {
			System.out.println("�����Դϴ�.");
		} else {
			System.out.println("��ü���Դϴ�.");
		}
	}

	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
}
