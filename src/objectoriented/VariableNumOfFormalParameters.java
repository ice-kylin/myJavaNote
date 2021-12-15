package objectoriented;

/*
# 可变个数的形参

1. JDK 5.0 新增的内容
2. 具体使用：
  - 格式：`数据类型... 变量名`
  - 当调用可变个数形参的方法时，传入的参数可以是：0 个、1 个、2 个...
  - 可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
  - 可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载
    - 换句话说，两者不能共存
  - 可变个数形参在方法的形参中，必须声明在末尾
  - 可变个数形参在方法的形参中，最多只能声明一个可变个数形参
 */
public class VariableNumOfFormalParameters {
    public static void main(String[] args) {
        VariableNumOfFormalParameters variableNumOfFormalParameters = new VariableNumOfFormalParameters();
        variableNumOfFormalParameters.showMsg(233);
        variableNumOfFormalParameters.showMsg("Hello");
        variableNumOfFormalParameters.showMsg("Hello", "World");
        variableNumOfFormalParameters.showMsg(new String[]{"Hello", "World"});
    }

    public void showMsg(int i) {
        System.out.println(i);
    }

    public void showMsg(String s) {
        System.out.println(s);
    }

    // public void showMsg(String[] strs)
    public void showMsg(String... strs) {
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
