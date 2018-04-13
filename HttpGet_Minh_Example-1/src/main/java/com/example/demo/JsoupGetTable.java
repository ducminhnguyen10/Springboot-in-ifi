package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupGetTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc = null;
		List<Bandwithd> listBandWithd = new ArrayList<Bandwithd>();
		try {
			doc = (Document) Jsoup.connect("http://mse.mseifis.local/bandwithd/index.html#192.168.81.64-1").get();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		for (Element center : doc.select("center")) {
			for (Element table : center.select("table")) {
				for (Element row : table.select("tr")) {
					Elements tds = row.select("td");
					// System.out.println(tds.text());

					listBandWithd.add(new Bandwithd(tds.get(0).text(), tds.get(1).text(), tds.get(2).text(),
							tds.get(3).text(), tds.get(4).text(), tds.get(5).text(), tds.get(6).text(),
							tds.get(7).text(), tds.get(8).text(), tds.get(9).text()));

				}

			}
		}

	}

}
