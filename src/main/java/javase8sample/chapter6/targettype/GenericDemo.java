/*
 * Copyright 2013 benhaile.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package javase8sample.chapter6.targettype;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述: 泛型自动推断类型
 * 
 * @作者: 王鹏
 * @创建时间: 2016年7月19日-下午3:45:44
 * @版本: 1.0
 */
public class GenericDemo<E> {

    static <Z> GenericDemo<Z> nil() {
        return null;
    }

    static <Z> GenericDemo<Z> cons(Z head, GenericDemo<Z> tail) {
        return null;
    }

    E head() {
        return null;
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.addAll(new ArrayList());
        
        GenericDemo<Integer> nil = GenericDemo.nil(); // 根据返回值的类型, 推断泛型参数类型
        Integer head = nil.head();
        
        GenericDemo<String> cons = GenericDemo.cons("头部", GenericDemo.nil());
        String head2 = cons.head();
    }
}
