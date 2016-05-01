package pro.smartum.app.business.utils;

import pro.smartum.app.dto.BaseDto;
import pro.smartum.app.model.Identifier;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by eldar.s on 25.04.2016.
 */
public class ConvertedList<T extends BaseDto> extends ArrayList<T> {

    private static final long serialVersionUID = 1L;

    public ConvertedList() {
    }

    public ConvertedList(Collection<? extends Object> c) {
        super(ConvertUtil.convert(c)); // for initialize our List(see LinkedList constructor)
    }

    public ConvertedList(Collection<? extends Identifier> c, Comparator<T> comparator) {
        super(sort(ConvertUtil.convert(c), comparator));
    }

    public boolean addAllConverted(Collection<? extends Identifier> c) {
        return this.addAll(ConvertUtil.convert(c));
    }

    private static <K  extends BaseDto> Collection<K> sort(Collection<K> collection, Comparator<K> comparator) {
        List<K> list = new LinkedList<K>(collection);
        Collections.sort(list, comparator);
        return list;
    }


}
