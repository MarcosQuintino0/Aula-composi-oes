package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import exercise.Client;
import exercise.Order;
import exercise.OrderItem;
import exercise.Product;
import exercise.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client =new Client(name, email,birthDate);
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next()); //essa funcao converte o string para o valor correspondente definido lá no orderStatus 
		
		Order order = new Order(new Date(),status,client);
		
		System.out.println("How many items to this order?: ");
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			System.out.println("Enter #"+ i +" item data: ");
			System.out.println("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.println("Product price: ");
			double priceProduct = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantityProduct = sc.nextInt();
			
			Product product =new Product(nameProduct,priceProduct); //criei na memoria um produto
			
			OrderItem it =new OrderItem(quantityProduct,priceProduct,product); //criei na memoria um ordermItm associado com o produto
			
			order.addItem(it);
		}
		
		System.out.println();
		System.out.println(order);
		
		

		

		sc.close();
		// System.out.println(oi1.getProduct().getName()); //acessei o produto  no oi1 e depois pegeui o nome
	}

}
