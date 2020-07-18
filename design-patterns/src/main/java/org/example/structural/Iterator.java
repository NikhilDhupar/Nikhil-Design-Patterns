package org.example.structural;

interface IteratorSample {
    boolean hasNext();

    Object next();
}

class NamesCollection {

    public String mNames[] = {"ABC", "DEF", "GHI", "JKL", "LMN", "OPQ", "RST", "UVW", "XYZ"};

    public IteratorSample getIterator() {
        return new IterateNamesCollection();
    }

    private class IterateNamesCollection implements IteratorSample {
        int mIndex;

        @Override
        public boolean hasNext() {
            if (mIndex < mNames.length)
                return true;
            else
                return false;
        }

        @Override
        public Object next() {
            if ( this.hasNext() )
                return mNames[mIndex++];
            else
                return null;
        }
    }
}

public class Iterator {

    public static void main(String[] args) {

        NamesCollection mCompanyRepo = new NamesCollection();

        for (IteratorSample iterator = mCompanyRepo.getIterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();
            System.out.println("NAME : " + name);
        }
    }
}
