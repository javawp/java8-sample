/*
 * Copyright 2013 foreveross.
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
package javase8sample.chapter3.stream;
import java.util.stream.IntStream;

/**
 *
 * @author benhail
 */
public class ParallelStreamTest {

    public static void main(String[] args) {
        long t0 = System.nanoTime();
        //初始化一个范围100万整数流,求能被2整除的数字，toArray（）是终点方法
        int a[]=IntStream.range(0, 1_000_000).filter(p -> p % 2==0).toArray();
        long t1 = System.nanoTime();
        //和上面功能一样，这里是用并行流来计算
        int b[]=IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2==0).toArray();
        long t2 = System.nanoTime();
        //我的结果是serial: 0.06s, parallel 0.02s，证明并行流确实比顺序流快
        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);
    }
}
