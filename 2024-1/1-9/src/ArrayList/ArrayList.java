package ArrayList;

import java.util.Arrays;

public class ArrayList implements IList{

    public int[] elem;
    public int usedSize;
    public static final int DEFAULT_CAPACITY = 3;

    public ArrayList() {
        this.elem = new int[DEFAULT_CAPACITY];
        this.usedSize = 0;
    }

    @Override
    public void display() {
        for (int i = 0;i < usedSize;i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    // 尾插
    @Override
    public void add(int data) {
        if (isFull()) {
            // 扩容
            this.elem = Arrays.copyOf(elem,elem.length * 2);
        }
        elem[usedSize++] = data;
    }

    private boolean isFull() {
        return usedSize == elem.length;
    }

    // pos位置插入数据
    @Override
    public void add(int pos, int data) {
        // 判断 Pos位置是否合法
        if (pos < 0 || pos > usedSize) {
            throw new PosException(pos + ":非法输入");
        }
        if (isFull()) {
            // 扩容
            this.elem = Arrays.copyOf(elem,elem.length * 2);
        }
        // 移动数据
        for (int i = usedSize-1;i >= pos;i--) {
            elem[i+1] = elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    @Override
    public boolean contains(int toFind) {
        for (int i = 0;i < usedSize;i++) {
            if (elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    @Override
    public int indexOf(int toFind) {
        for (int i = 0;i < usedSize;i++) {
            if (elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    // 获取 pos 位置的元素
    @Override
    public int get(int pos) {
        // 判断pos位置
        if (pos < 0 || pos < usedSize-1) {
            throw new Pos2Exception(pos + "非法输入");
        }
        // 判断是否为空
        if (isEmpty()) {
            throw new EmptyException("顺序表为空 不可获取元素");
        }
        return elem[pos];
    }

    // 给 pos 位置的元素设为 value
    @Override
    public void set(int pos, int value) {
        // 判断pos位置
        if (pos < 0 || pos < usedSize-1) {
            throw new Pos2Exception(pos + "非法输入");
        }
        // 判断是否为空
        if (isEmpty()) {
            throw new EmptyException("顺序表为空 不可获取元素");
        }
        elem[pos] = value;
    }

    // 删除第一次出现的关键字key
    @Override
    public void remove(int toRemove) {
        // 1. 如果为空 不能删除
        if (isEmpty()) {
            throw new EmptyException("顺序表为空 不能删除");
        }

        // 2. 找到下标
        int index = indexOf(toRemove);
        if (index == -1) {
            return;
        }

        // 3. 移动覆盖删除
        for (int i = index;i < usedSize-1;i++) {
            elem[i] = elem[i+1];
        }
        usedSize--;
    }

    @Override
    public void clear() {
        this.elem = null;
        this.usedSize = 0;
    }
}
