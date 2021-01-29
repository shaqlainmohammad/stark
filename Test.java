import java.util.Scanner;
class Variables{
	//Economy car---------------------------
	final static int  basicRentalFare=750;
	final static int basicDiscount=200;
	final static int rateExcessKm=8;
	final static int rateExcessHr=125;
	final static double serviceTax=.06;
	final static int timelimit=8;
	final static int disEconomyLimit=50;
	
	//Executive car--------------------
	final static double  basicRentalFareExecutiveFactor=1.5;
	final static double basicDiscountExecutiveFactor=1;
	final static double rateExcessKmExecutiveFactor=0.5;
	final static double rateExcessHrExecutiveFactor=0.2;
	final static double corporateDiscountExecutive=0.1;
	final static int disEconomyLimitExecutive=100;
	
	//Suv car----------------------------------
	final static double  basicRentalFareSuvFactor=2;
	final static double basicDiscountSuvFactor=1.5;
	final static double rateExcessKmSuvFactor=0.75;
	final static double rateExcessHrSuvFactor=0.5;
	final static double corporateDiscountSuv=0.15;
	final static int disSuvLimit=150;
	
}
abstract class Car{
	double basicRentalFare,basicDiscount,corporateDiscount,rateexcesskm,rateexcesshr,tax,totalrateforexkm,totalrateforexhr;
	int timelimit,dislimit;
	abstract double netFare(Customer c1);
	abstract double grossFare(Customer c1);
	abstract double totalFare(Customer c1);
	abstract double totalRateForExtraKm(Customer c1);
	abstract double totalRateForExtrahrs(Customer c1);
}
class Economy extends Car{
	Economy()
	{
	basicRentalFare=Variables.basicRentalFare;
	basicDiscount=Variables.basicDiscount;
	rateexcesskm=Variables.rateExcessKm;
	rateexcesshr=Variables.rateExcessHr;
	tax=Variables.serviceTax;
	dislimit=Variables.disEconomyLimit;
	timelimit=Variables.timelimit;
	}
	double netFare(Customer c1) {
		return grossFare(c1)+tax;
	}
	double grossFare(Customer c1) {
		return totalFare(c1)-basicDiscount;
		
	}
	double totalFare(Customer c1) {
		if(c1.time>timelimit && c1.dis<=dislimit)
			return totalRateForExtrahrs(c1)+basicRentalFare;
		else if(c1.time<=timelimit && c1.dis>dislimit)
			return totalRateForExtraKm(c1)+basicRentalFare;
		else if (c1.time>timelimit && c1.dis>dislimit)
		{
		totalrateforexkm=totalRateForExtraKm(c1);
		totalrateforexhr=totalRateForExtrahrs(c1);
		if (totalrateforexkm>totalrateforexhr)
			return totalrateforexkm+basicRentalFare;
		else return totalrateforexhr+basicRentalFare;
		}
		else return basicRentalFare;
	}
	double totalRateForExtraKm(Customer c1) {
		return (c1.dis-dislimit)* rateexcesskm;
	}
	double totalRateForExtrahrs(Customer c1)
	{
		return (c1.time-timelimit)*rateexcesshr;
	}
}
class Executive extends Car{
	Executive()
	{
	basicRentalFare=Variables.basicRentalFare * Variables.basicRentalFareExecutiveFactor;
	basicDiscount=Variables.basicDiscount * Variables.basicDiscountExecutiveFactor;
	rateexcesskm=(Variables.rateExcessKm* Variables.rateExcessKmExecutiveFactor)+Variables.rateExcessKm;
	rateexcesshr=(Variables.rateExcessHr* Variables.rateExcessHrExecutiveFactor)+Variables.rateExcessHr;
	tax=Variables.serviceTax;
	corporateDiscount=Variables.corporateDiscountExecutive;
	dislimit=Variables.disEconomyLimit;
	timelimit=Variables.timelimit;
	}
	double netFare(Customer c1) {
		return grossFare(c1)+tax;
	}	
	double grossFare(Customer c1) {
		return totalFare(c1)-(basicDiscount+corporateDiscount);
		
	}
	double totalFare(Customer c1) {
		if(c1.time>timelimit && c1.dis<=dislimit)
			return totalRateForExtrahrs(c1)+basicRentalFare;
		else if(c1.time<=timelimit && c1.dis>dislimit)
			return totalRateForExtraKm(c1)+basicRentalFare;
		else if (c1.time>timelimit && c1.dis>dislimit)
		{
		totalrateforexkm=totalRateForExtraKm(c1);
		totalrateforexhr=totalRateForExtrahrs(c1);
		if (totalrateforexkm>totalrateforexhr)
			return totalrateforexkm+basicRentalFare;
		else return totalrateforexhr+basicRentalFare;
		}
		else return basicRentalFare;
	}
	double totalRateForExtraKm(Customer c1) {
		return (c1.dis-dislimit)* rateexcesskm;
	}
	double totalRateForExtrahrs(Customer c1)
	{
		return (c1.time-timelimit)*rateexcesshr;
	}
}
class Suv extends Car{
	Suv()
	{basicRentalFare=Variables.basicRentalFare * Variables.basicRentalFareSuvFactor;
	basicDiscount=Variables.basicDiscount * Variables.basicDiscountSuvFactor;
	rateexcesskm=(Variables.rateExcessKm* Variables.rateExcessKmSuvFactor)+Variables.rateExcessKm;
	rateexcesshr=(Variables.rateExcessHr* Variables.rateExcessHrSuvFactor)+Variables.rateExcessHr;
	tax=Variables.serviceTax;
	corporateDiscount=Variables.corporateDiscountSuv;
	dislimit=Variables.disSuvLimit;
	timelimit=Variables.timelimit;
	}
	double netFare(Customer c1) {
		return grossFare(c1)+tax;
	}	
	double grossFare(Customer c1) {
		return totalFare(c1)-(basicDiscount+corporateDiscount);
		
	}
	double totalFare(Customer c1) {
		if(c1.time>timelimit && c1.dis<=dislimit)
			return totalRateForExtrahrs(c1)+basicRentalFare;
		else if(c1.time<=timelimit && c1.dis>dislimit)
			return totalRateForExtraKm(c1)+basicRentalFare;
		else if (c1.time>timelimit && c1.dis>dislimit)
		{
		totalrateforexkm=totalRateForExtraKm(c1);
		totalrateforexhr=totalRateForExtrahrs(c1);
		if (totalrateforexkm>totalrateforexhr)
			return totalrateforexkm+basicRentalFare;
		else return totalrateforexhr+basicRentalFare;
		}
		else return basicRentalFare;
	}
	double totalRateForExtraKm(Customer c1) {
		return (c1.dis-dislimit)* rateexcesskm;
	}
	double totalRateForExtrahrs(Customer c1)
	{
		return (c1.time-timelimit)*rateexcesshr;
	}
}
class FactoryClass{
private static FactoryClass singleins;
	private FactoryClass(){}
	public static FactoryClass FactoryIns()
{
		if(singleins==null)
		singleins=new FactoryClass();
		return singleins;
}
     Car factoryMethod(String str1) 
	{
	if(str1=="economy")
		return new Economy();
	else if (str1=="executive")
		return new Executive();
	else
		return new Suv();
	}
}
class Customer{
	double dis,time;
	int id;
	Customer(double dis,double time,int id){
		this.dis=dis;
		this.time=time;
		this.id=id;
	}
	
}
class Test{
public static void main(String args[]){
		FactoryClass f1=FactoryClass.FactoryIns();
		Car car1=f1.factoryMethod("executive");
		Customer c1=new Customer(200,10,123);
		Rent r1=new Rent(car1,c1);
		r1.calculation();}
		
}
class Rent{
	Car car1;
	Customer c1;
	Rent(Car car1,Customer c1){
		this.car1=car1;
		this.c1=c1;
	}
void calculation(){
	car1.netFare(c1);
	System.out.println(car1.netFare(c1));
}
}
