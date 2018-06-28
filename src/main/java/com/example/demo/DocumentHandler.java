package com.example.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DocumentHandler {

	public static List<Record> getRecord() {
		List<Record> records = new ArrayList<Record>();
		records.add(new Record(1, "年龄", "22"));
		records.add(new Record(2, "姓名", "zhangsan"));
		records.add(new Record(3, "邮箱", "dsadsaj@qq.com"));
		records.add(new Record(4, "地址", "d啊倒萨打算"));

		return records;
	}

	public static List<?> getData() {
		List<Record> records = getRecord();
		Map<Integer, Record> recordMap = records.stream()
				.collect(Collectors.toMap(Record::getId, a -> a, (k1, k2) -> k1));
		Map<Integer, Record> leftMap = new HashMap<Integer, Record>();
		Map<Integer, Record> rightMap = new HashMap<Integer, Record>();
		List<Object> headLists = new ArrayList<Object>();
		int arraySize = 0;
		if (records.size() % 2 > 0) {
			arraySize = (records.size() + 1) / 2;
		} else {
			arraySize = records.size() / 2;
		}
		HeadList[] headArray = new HeadList[arraySize];

		for (Map.Entry<Integer, Record> entry : recordMap.entrySet()) {
			if (entry.getKey() == 1 || entry.getKey() % 2 != 0) {
				leftMap.put(entry.getKey(), entry.getValue());
				/*
				 * h.setItemName(entry.getValue().getItemKey());
				 * h.setItemVal(entry.getValue().getItemValue());
				 */
			} else {
				rightMap.put(entry.getKey(), entry.getValue());
				/*
				 * h.setItemName1(entry.getValue().getItemKey());
				 * h.setItemVal1(entry.getValue().getItemValue());
				 */
			}
		}

		for (int i = 1; i <= headArray.length; i++) {
			HeadList h = new HeadList();
			if (i == 1) {
				h.setItemName(recordMap.get(i).getItemKey());
				h.setItemVal(recordMap.get(i).getItemValue());
				h.setItemName1(recordMap.get(i + 1).getItemKey());
				h.setItemVal1(recordMap.get(i + 1).getItemValue());
			} else {
				h.setItemName(recordMap.get(i + 1).getItemKey());
				h.setItemVal(recordMap.get(i + 1).getItemValue());
				h.setItemName1(null == recordMap.get(i + 2) ? "" : recordMap.get(i + 2).getItemKey());
				h.setItemVal1(null == recordMap.get(i + 2) ? "" : recordMap.get(i + 2).getItemValue());
			}

			headArray[i - 1] = h;
		}
		headLists = Arrays.asList(headArray);
		return headLists;

	}
	
	public static List<Student> getStudents(){
		List<Student> students = new ArrayList<Student>();
		Student s = new Student("張三","計算機","32","通過");
		Student s1 = new Student("張三1","計算機1","32","通過3");
		Student s2 = new Student("張三2","計算機2","32","通過3");
		Student s3 = new Student("張三3","計算機3","32","通過3");
		students.add(s);
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		
		return students;
	}

	public static File createDoc() {
		
		List<?> headLists = getData();
		List<Student> middleList = getStudents();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("tableName","xxxjilubiasdsd上的得到 上");
		dataMap.put("headList", headLists);
		dataMap.put("middleList", middleList);

		// 获取模板
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(DocumentHandler.class, "/templates");
		Template t = null;

		String name = "c:\\temp" + (int) (Math.random() * 1000) + ".doc";
		File file = new File(name);
		try {
			t = configuration.getTemplate("word1.xml");
			t.setEncoding("UTF-8");

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), "UTF-8"));
			t.process(dataMap, out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace(); 
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return file;
	}

	public static void main(String[] args) {
		File file = createDoc();
		// System.out.println(1/2);
		// System.out.println(3/2);
	}
}
