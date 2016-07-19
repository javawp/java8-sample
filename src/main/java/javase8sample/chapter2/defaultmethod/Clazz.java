package javase8sample.chapter2.defaultmethod;

/**
 * Created by benhail on 2014/5/19.
 */
public class Clazz implements A {
	
	@Override
	public void hello() {
		A.super.hello();
	}

    public static void main(String[] args){

        Clazz clazz = new Clazz();

        clazz.hello();//调用a的默认方法

    }

}

