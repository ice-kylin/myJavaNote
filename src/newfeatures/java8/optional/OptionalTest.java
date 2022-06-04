package newfeatures.java8.optional;

import org.junit.Test;

import java.util.Optional;

/*
# Optional

- 为了在程序中避免出现空指针异常而创建的
 */
public class OptionalTest {
    private static String getGirlName(Boy b) {
        return b.getGirl().getName();
    }

    // 使用 Optional 类的 getGirlName() 方法
    private static String getGirlName1(Boy b) {
        return Optional.
                ofNullable(
                        Optional
                                .ofNullable(b)
                                .orElse(new Boy())
                                .getGirl()
                ).orElse(
                        new Girl()
                ).getName();
    }

    /*
    - of()：创建一个 Optional 实例，t 必须非空
    - get()：如果调用对象包含值，返回该值，否则抛异常
    - isPresent()：判断是否包含对象
     */
    @Test
    public void test1() {
        Optional<Girl> girl = Optional.of(
                new Girl()
        );

        System.out.println(girl);

        if (girl.isPresent()) {
            Girl girl1 = girl.get();

            System.out.println(girl1);
        }
    }

    /*
    - empty()：创建一个空的 Optional 实例
     */
    @Test
    public void test2() {
        Optional<Object> empty = Optional.empty();

        System.out.println(empty);
    }

    /*
    - ofNullable()：t 可以为 null
    - orElse()
      - 如果当前的 Optional 内部封装的 t 是非空的，则返回内部的 t
      - 如果内部的 t 是空的，则返回 orElse() 方法中的参数 other
     */
    @Test
    public void test3() {
        Girl girl = null;
        Optional<Girl> girlOptional = Optional.ofNullable(
                girl
        );

        Girl girl1 = girlOptional.orElse(
                new Girl(
                        "icekylin"
                )
        );

        System.out.println(girlOptional);
        System.out.println(girl1);
    }

    @Test
    public void test4() {
        Boy boy = new Boy(
                new Girl(
                        "icekylin"
                )
        );

        System.out.println(
                getGirlName(boy)
        );
    }

    @Test
    public void test5() {
        Boy boy = new Boy(
                new Girl(
                        "icekylin"
                )
        );

        System.out.println(
                getGirlName1(boy)
        );

        Boy boy1 = new Boy();

        System.out.println(
                getGirlName1(boy1)
        );

        System.out.println(
                getGirlName1(null)
        );
    }
}
