package javase8sample.chapter3.stream;

import java.util.*;
import java.util.stream.*;

import static java.util.Comparator.comparing;

public class StreamBasic {

    public static void main(String...args){
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
        
        System.out.println("---");
        
        collectorGroupingByInJava8(Dish.menu);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() > 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() > 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .parallel() // 使用并行流
                .collect(Collectors.toList());
//              .collect(Collectors.toCollection(ArrayList::new)); // 指定转换集合
    }
    
	public static void collectorGroupingByInJava8(List<Dish> dishes) {
		dishes.stream().collect(Collectors.groupingBy(Dish::getType)).forEach((i, d) -> {
			System.out.println("Collectors.groupingBy [分组] -- > [类型]: " + i + " [数量]: " + d.size());
		});
	}
    
}
