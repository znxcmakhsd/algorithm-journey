package ArrayList;

public interface IList {
    // 打印所有元素
    void display();

    // 新增元素,默认在数组最后新增
    void add(int data);

    // 在 pos 位置新增元素
    void add(int pos, int data);

    // 判定是否包含某个元素
    boolean contains(int toFind);

    // 查找某个元素对应的位置
    int indexOf(int toFind);

    // 获取 pos 位置的元素
    int get(int pos);

    // 给 pos 位置的元素设为 value
    void set(int pos, int value);

    //删除第一次出现的关键字key
    void remove(int toRemove);

    // 获取顺序表长度
    int size();

    // 清空顺序表
    void clear();
}