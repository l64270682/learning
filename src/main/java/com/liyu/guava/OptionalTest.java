package com.liyu.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author liyu
 * @date:2018/8/20
 * @describe:
 */
@Slf4j
public class OptionalTest {

    public static void main(String[] args) {
        HashMultiset hashMultiset = HashMultiset.create();
        ArrayList<Integer> arrayList = Lists.newArrayList();
        arrayList.add(1);
        arrayList.add(10);
        arrayList.add(2);
        arrayList.add(1);
        String join = Joiner.on(",").join(arrayList);

    }

}
