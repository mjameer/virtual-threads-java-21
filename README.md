# virtual-thread-demo


![image](https://github.com/mjameer/virtual-threads-java-21/assets/11364104/2742ebe7-b3ce-411e-893f-f07d8f4caf93)


![image](https://github.com/mjameer/virtual-threads-java-21/assets/11364104/b6132fc3-fa35-4fcc-9ad8-4d5c13688a45)



![image](https://github.com/mjameer/virtual-threads-java-21/assets/11364104/1d3e0a73-ce01-43bf-8e95-dfdc5ed519d7)



![image](https://github.com/mjameer/virtual-threads-java-21/assets/11364104/4d67458b-925d-4d7c-9cf3-cf8e61a6aac3)



![image](https://github.com/mjameer/virtual-threads-java-21/assets/11364104/e5ace806-4c84-4d1c-b70e-602da561539a)

Output for 100,000 Platform threads 


![image](https://github.com/mjameer/virtual-threads-java-21/assets/11364104/910eade3-3c89-4dca-804f-74091998298d)

For the same 100,000 Virtual threads its takes about 500ms

![image](https://github.com/mjameer/virtual-threads-java-21/assets/11364104/d754c6a3-daf6-4350-9ec0-7a52a89538e3)

VirtUAL Threads for Executor 


![image](https://github.com/mjameer/virtual-threads-java-21/assets/11364104/366ed078-ee5d-4eed-abc1-3468a5241f4d)


Here a Virtual thread is created for every task that is submitted, so the concept of CachedThreadPool for Executor servece is eliminated for Virtual thread 



What is a Virtual Thread?
Like a platform thread, a virtual thread is also an instance of java.lang.Thread. However, a virtual thread isn't tied to a specific OS thread. A virtual thread still runs code on an OS thread. However, when code running in a virtual thread calls a blocking I/O operation, the Java runtime suspends the virtual thread until it can be resumed. The OS thread associated with the suspended virtual thread is now free to perform operations for other virtual threads.

Virtual threads are implemented in a similar way to virtual memory. To simulate a lot of memory, an operating system maps a large virtual address space to a limited amount of RAM. Similarly, to simulate a lot of threads, the Java runtime maps a large number of virtual threads to a small number of OS threads.

Unlike platform threads, virtual threads typically have a shallow call stack, performing as few as a single HTTP client call or a single JDBC query. Although virtual threads support thread-local variables and inheritable thread-local variables, you should carefully consider using them because a single JVM might support millions of virtual threads.

``` Virtual threads are suitable for running tasks that spend most of the time blocked, often waiting for I/O operations to complete. However, they aren't intended for long-running CPU-intensive operations.```


