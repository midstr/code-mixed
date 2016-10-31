import com.google.common.base.*;
import com.google.common.collect.*;
import com.google.common.hash.*;
import com.google.common.io.*;
import com.google.common.math.IntMath;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyaogang on 16/10/14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int[] ary = {3, 2, 3, 9, 2};

        Arrays.stream(ary).sorted().forEach((a) ->
                ++a
        );
        System.out.println(Arrays.stream(ary).min().orElse(-1));
        System.out.println(Arrays.toString(ary));

        List<Integer> list = Arrays.asList(5, 2, 4, 6, 9);
        list.stream().sorted();

        list.forEach((i) -> System.out.println(i));

        ListMultimap<Integer, String> listMultimap = ArrayListMultimap.create();
        listMultimap.put(1, "101");
        listMultimap.put(1, "102");
        listMultimap.put(2, "201");
        System.out.println(listMultimap);
        System.out.println(listMultimap.asMap());

        ImmutableList<Integer> immutableList = ImmutableList.of(1, 2, 3);

        Multiset<Integer> multiset = HashMultiset.create();
        multiset.add(1);
        multiset.add(2);
        multiset.add(1);
        multiset.add(1);
        multiset.add(3);

        //System.out.println(multiset.count(2));
        multiset.elementSet().forEach(e -> System.out.println(e));
        multiset.entrySet().forEach(e -> System.out.println(e.getElement() + ":" + e.getCount()));
        System.out.println(multiset.size());


        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "11");
        biMap.put(2, "22");
        biMap.put(1, "33");
        System.out.println(biMap);
        System.out.println(biMap.inverse().get("22"));

        Table<Integer, Integer, Integer> table = HashBasedTable.create();
        table.put(1, 2, 2);
        table.put(1, 2, 22);
        table.put(1, 3, 44);
        System.out.println(table);



        List<String> newList = Lists.transform(list, (x) -> (x + "s"));
        System.out.println(newList);

        ListenableFuture<Integer> futrue = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool()).submit
                (new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(10);
                return 111;
            }
        });
        Futures.addCallback(futrue, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("succ..." + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.printf("failk.." + Throwables.getStackTraceAsString(t)) ;
            }
        });

        System.out.println(CharMatcher.WHITESPACE.removeFrom("a f"));

        System.out.println(Range.lessThan(4.0).contains(2d));

        Readable readable = new StringReader("xxxx");
        try {
            CharSource.wrap("liyg").copyTo(Files.asCharSink(new File("/Users/liyaogang/test.log"), Charsets.UTF_8, FileWriteMode
                        .APPEND));



            HashCode hash = Files.asByteSource(new File("/Users/liyaogang/test.log")).hash(Hashing.sha1());

            System.out.println(hash);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int ret = IntMath.checkedAdd(Integer.MAX_VALUE-1, 1);
        System.out.println(ret);


        ClassLoader sys = ClassLoader.getSystemClassLoader();
        ClassLoader cur = Thread.currentThread().getContextClassLoader();
        System.out.println(sys);
        System.out.println(cur);
        ClassPath classpath = ClassPath.from(sys); // scans the class path used by classloader
        for (ClassPath.ClassInfo classInfo : classpath.getAllClasses()) {
//            System.out.println(classInfo);
        }
        for (ClassPath.ResourceInfo resourceInfo : classpath.getResources()) {
           //System.out.println(resourceInfo);
        }


        System.out.println();

        MyList<Integer> myList = new MyList<Integer>(new ArrayList<>());
        myList.add(1);
        System.out.println(myList.type);


       TypeToken<String> type = new MyList<String>(new ArrayList<>()).type;
       TypeToken<?> rtype = type.resolveType(MyList.class.getTypeParameters()[0]);
        System.out.println(rtype);

//        TypeToken<ArrayList<String>> typeToken = new TypeToken<ArrayList<String>>() {};
//        TypeToken<?> genericTypeToken = typeToken.resolveType(ArrayList.class.getTypeParameters()[0]);
//        System.out.println(genericTypeToken.getType());
    }



    static class MyList<E> extends ForwardingList<E> {
        TypeToken<E> type = new TypeToken<E>(getClass()) {
        };

//        bstract class IKnowMyType<T> {
//            TypeToken<T> type = new TypeToken<T>(getClass()) {};
//        }
//        ...
//                new IKnowMyType<String>() {}.type;

        public MyList(List<E> delegate) {
            this.delegate = delegate;
        }

        final List<E> delegate;

        @Override
        protected List<E> delegate() {
            return delegate;
        }

        @Override
        public boolean add(E element) {
            System.out.println(element);
            return super.add(element);
        }
    }
}
