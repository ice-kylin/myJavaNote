package exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
# 重写方法异常抛出的规则
- 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 */
public class OverrideTest {
}

class SuperClass {
    public void m1() throws IOException {
    }
}

class SubClass extends SuperClass {
    @Override
    public void m1() throws FileNotFoundException {
    }
}
