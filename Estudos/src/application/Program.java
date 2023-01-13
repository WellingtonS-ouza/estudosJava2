package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Price: ");
			double productPrice = sc.nextDouble();

			if (ch == 'c') {
				list.add(new Product(productName, productPrice));

			} else if (ch == 'i') {
				System.out.print("Customs fee:");
				double customFee = sc.nextDouble();

				list.add(new ImportedProduct(productName, productPrice, customFee));

			} else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), fmt);

				list.add(new UsedProduct(productName, productPrice, date ));

			}

		}

		System.out.println();
		System.out.println("PRICE TAGS: ");

		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}

}
