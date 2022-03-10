import java.util.ArrayList;
import java.util.List;

class PythagoreanTriplet{
    private int a, b, c;

    public PythagoreanTriplet(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTripletBuilder();
    }

    static class PythagoreanTripletBuilder{
        int limit, sum;

        PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int lower){
            this.limit = lower;
            return this;
        }

        PythagoreanTripletBuilder thatSumTo(int sum) {
            this.sum = sum;
            return this;
        }

        List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> result = new ArrayList<PythagoreanTriplet>();

            for (int a=1; a<=limit; a++) {
                for (int b=a+1; b<=limit; b++) {
                    int c = sum - a - b;

                    if (a*a + b*b == c*c) {
                        result.add(new PythagoreanTriplet(a, b, c));
                    }
                }
            }
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        PythagoreanTriplet ob= (PythagoreanTriplet) o;
        if(this.a==ob.a&&this.b==ob.b&&this.c==ob.c)
            return true;
        return false;
    }
}
