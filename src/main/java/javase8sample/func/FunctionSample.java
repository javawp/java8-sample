package javase8sample.func;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @描述: default <V> Function<T,V> compose(Function<? super V,? extends T> before)返回一个先执行before函数对象apply方法再执行当前函数对象apply方法的函数对象。<br>
 * 		  default <V> Function<T,V> andThen(Function<? super R,? extends V> after) 返回一个先执行当前函数对象apply方法再执行after函数对象apply方法的函数对象。<br>
 * 
 * @作者: 王鹏
 * @创建时间: 2016年7月21日-上午11:13:54
 * @版本: 1.0
 */
public class FunctionSample {

	public static void main(String[] args) {

		Function<Integer, Integer> times2 = e -> e * 2;

		Function<Integer, Integer> squared = e -> e * e;

		Integer before = times2.compose(squared).apply(4); // (4 * 4) * 2
		// Returns 32
		System.out.println(before);

		Integer after = times2.andThen(squared).apply(4); // (4 * 2) * (4 * 2)
		// Returns 64
		System.out.println(after);

		BiFunction<Integer, Integer, Integer> biFunction = (e1, e2) -> e1 + e2;
		Integer apply = biFunction.andThen(squared).apply(4, 2); // (4 + 2) * (4 + 2)
		System.out.println(apply);
		// Returns 36
	}
}
