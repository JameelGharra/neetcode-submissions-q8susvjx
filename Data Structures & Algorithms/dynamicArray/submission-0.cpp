class DynamicArray {
private:
    int* data;
    int capacity;
    int size = 0; // actual size
public:
    DynamicArray(int capacity): capacity(capacity), data(new int[capacity]) {
        
    }

    int get(int i) {
        return data[i];
    }

    void set(int i, int n) {
        data[i] = n;
    }

    void pushback(int n) {
        if(size == capacity) {
            resize();
        }
        data[size++] = n;
    }

    int popback() {
        --size;
        return data[size];
    }

    void resize() {
        int* new_data = new int[2*capacity];
        for(int i = 0; i < capacity; ++i) {
            new_data[i] = data[i];
        }
        delete[] data;
        data = new_data;
        capacity = 2*capacity;
    }

    int getSize() {
        return size;
    }

    int getCapacity() {
        return capacity;
    }
};
