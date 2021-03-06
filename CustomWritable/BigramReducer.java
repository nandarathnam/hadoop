import java.io.IOException;
 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
 
public class BigramReducer extends Reducer<TextPair, IntWritable, Text, IntWritable>{
    private static Text textPairText = new Text();
    @Override
    public void reduce(TextPair key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
    {
        int count=0;
        for(IntWritable value: values)
        {
            count += value.get();
        }
 
        textPairText.set(key.toString());
        context.write(textPairText, new IntWritable(count));
    }
}
