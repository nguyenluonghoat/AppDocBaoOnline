package com.mjschievous.docbaoonline.parser;

import android.os.AsyncTask;

import com.mjschievous.docbaoonline.listener.OnParseComplate;
import com.mjschievous.docbaoonline.model.Item;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Bao24hPullParser extends AsyncTask<String, Void, List<Item>> {
    private OnParseComplate mListener;

    public Bao24hPullParser(OnParseComplate mListener) {
        this.mListener = mListener;
    }

    @Override
    protected List<Item> doInBackground(String... arg) {
        String link = arg[0];
        List<Item> items = parserUrl(link);
        return items;
    }

    @Override
    protected void onPostExecute(List<Item> items) {
        super.onPostExecute(items);
        mListener.onComplate(items);
    }

    public List<Item> parserUrl(String link) {
        List<Item> items = new ArrayList<>();
        try {
            URL url = new URL(link);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();
            parser.setInput(inputStream, "UTF-8");

            String text = null;
            Item item = null;
            int type = parser.getEventType();
            while (type != XmlPullParser.END_DOCUMENT) {
                String tag = parser.getName();
                switch (type) {
                    case XmlPullParser.START_TAG:
                        if (tag.equals("item")) {
                            item = new Item();
                        } else if (tag.equals("img")) {
                            String thumb = parser.getAttributeValue(0);
                            item.setThumbUrl(thumb);
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (item == null) {
                            break;
                        }
                        if (tag.equals("item")) {
                            items.add(item);
                        } else if (tag.equals("title")) {
                            item.setTitle(text);
                        } else if (tag.equals("description")) {
                            item.setDescription(text);
                        } else if (tag.equals("link")) {
                            item.setDetailUrl(text);
                        } else if (tag.equals("pubDate")) {
                            item.setPubDate(text);
                        }
                        break;
                }
                type = parser.next();

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            mListener.onFailure(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            mListener.onFailure(e.getMessage());
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            mListener.onFailure(e.getMessage());
        }
        return items;
    }
}
