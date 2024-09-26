package com.mongodb.starter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

    public class PlatformThreadMonitor {
        private static final Set<Long> platformThreadIds = Collections.synchronizedSet(new HashSet<>());
        private static final AtomicInteger counter = new AtomicInteger(0);

        public static void logPlatformThread() {
            long threadId = Thread.currentThread().threadId();
            if (platformThreadIds.add(threadId)) {
                int currentCount = counter.incrementAndGet();
                System.out.println("New platform thread detected: " + threadId + " | Total unique platform threads: " + currentCount);
            }
        }

        public static int getUniqueThreadCount() {
            return counter.get();
        }
    }
