package com.jotish.octionltd.data;

/**
 * Created by jotishsuthar on 15/06/17.
 */

public class Media
{
  private String id;

  private String title;

  private String product_id;

  private String media;

  public String getId ()
  {
    return id;
  }

  public void setId (String id)
  {
    this.id = id;
  }

  public String getTitle ()
  {
    return title;
  }

  public void setTitle (String title)
  {
    this.title = title;
  }

  public String getProduct_id ()
  {
    return product_id;
  }

  public void setProduct_id (String product_id)
  {
    this.product_id = product_id;
  }

  public String getMedia ()
  {
    return media;
  }

  public void setMedia (String media)
  {
    this.media = media;
  }

  @Override
  public String toString()
  {
    return "ClassPojo [id = "+id+", title = "+title+", product_id = "+product_id+", media = "+media+"]";
  }
}


