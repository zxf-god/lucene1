package com.zxf.service;

import com.zxf.entity.Depart;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class LuceneServiceImpl implements LuceneService {
    @Resource
    private LuceneService luceneService;
    @Override
    public List<Depart> select(String name) {
        List<Depart> departs=new ArrayList<>();
        //指定索引搜索器中索引库的位置
        try {
            FSDirectory open = FSDirectory.open(new File("D:/IdeaProjects/index_lucene"));
            //读取索引库中相关信息
            DirectoryReader reader = DirectoryReader.open(open);
            //创建索引搜索器
            IndexSearcher searcher = new IndexSearcher(reader);
            //指定查询条件与内容
            TermQuery query = new TermQuery(new Term("d_name", name));
            TopDocs topDocs = searcher.search(query, 10);
            ScoreDoc[] docs = topDocs.scoreDocs;
            for (int i = 0; i <docs.length ; i++) {
                int doc = docs[i].doc;
                Document fields = searcher.doc(doc);
                Depart depart=new Depart(Integer.parseInt(fields.get("d_id")),fields.get("d_name"),fields.get("d_des"));
                departs.add(depart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departs;
    }

    @Override
    public void add(Depart depart) {
        //生成一个文件夹为索引库
            try {
                //生成一个文件夹为索引库
                FSDirectory directory = FSDirectory.open(new File("D:/IdeaProjects/index_lucene"));
                //创建标准分词器对象
                StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
                //索引写入库相关配置
                IndexWriterConfig writerConfig = new IndexWriterConfig(Version.LUCENE_44, analyzer);
                //加载相关配置，准备写入
                IndexWriter writer = new IndexWriter(directory, writerConfig);
                Document document = new Document();
                document.add(new StringField("d_id",depart.getD_id().toString(), Field.Store.YES));
                document.add(new TextField( "d_name",depart.getD_name(), Field.Store.YES));
                document.add(new TextField("d_des",depart.getD_des(), Field.Store.YES));
                writer.addDocument(document);
                writer.commit();
                writer.close();

            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void update(Depart depart) {

    }
}
