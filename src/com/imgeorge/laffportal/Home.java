package com.imgeorge.laffportal;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Home extends Fragment {

	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;
	private ViewFlipper mViewFlipper;
	private AnimationListener mAnimationListener;
	private Context mContext;
	View rootView;

	@SuppressWarnings("deprecation")
	private final GestureDetector detector = new GestureDetector(
			new SwipeGestureDetector());

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		try {
			rootView = inflater
					.inflate(R.layout.home_activty, container, false);
			setRetainInstance(true);
			mContext = this.getActivity();
			mViewFlipper = (ViewFlipper) this.rootView
					.findViewById(R.id.view_flipper);
			RelativeLayout rv = new RelativeLayout(this.getActivity());
			rv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			RelativeLayout rv1 = new RelativeLayout(this.getActivity());
			rv1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			RelativeLayout rv2 = new RelativeLayout(this.getActivity());
			rv2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			RelativeLayout rv3 = new RelativeLayout(this.getActivity());
			rv2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			RelativeLayout rv4 = new RelativeLayout(this.getActivity());
			rv4.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			RelativeLayout rv5 = new RelativeLayout(this.getActivity());
			rv5.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			RelativeLayout rv6 = new RelativeLayout(this.getActivity());
			rv6.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			RelativeLayout rv7 = new RelativeLayout(this.getActivity());
			rv7.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));

			String imageUrl = "http://laffportal.com/";

			LoaderImageView lImageView = new LoaderImageView(
					this.getActivity(), imageUrl, 0);
			LoaderImageView lImageView1 = new LoaderImageView(
					this.getActivity(), imageUrl, 1);
			LoaderImageView lImageView2 = new LoaderImageView(
					this.getActivity(), imageUrl, 2);
			LoaderImageView lImageView3 = new LoaderImageView(
					this.getActivity(), imageUrl, 3);
			LoaderImageView lImageView4 = new LoaderImageView(
					this.getActivity(), imageUrl, 4);
			LoaderImageView lImageView5 = new LoaderImageView(
					this.getActivity(), imageUrl, 5);
			LoaderImageView lImageView6 = new LoaderImageView(
					this.getActivity(), imageUrl, 6);
			LoaderImageView lImageView7 = new LoaderImageView(
					this.getActivity(), imageUrl, 7);
			// mImageViews[i] = lImageView;

			// imageView.setImageResource(R.drawable.lightning);

			// if (i != 0) {
			// RelativeLayout.LayoutParams Iparams = new
			// RelativeLayout.LayoutParams(
			// ViewGroup.LayoutParams.MATCH_PARENT,
			// ViewGroup.LayoutParams.WRAP_CONTENT);
			// Iparams.addRule(RelativeLayout.RIGHT_OF,
			// mImageViews[i - 1].getId());
			//
			// rv.addView(mImageViews[i], Iparams);
			// } else {
			// }

			TextView tv = new TextView(this.getActivity());

			tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 50));
			tv.setText("Swipe/Click to watch video");

			tv.setTextAppearance(this.getActivity(), R.style.ImageTitle);

			tv.setBackgroundResource(R.color.Textcolor);
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
			params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, tv.getId());
			tv.setLayoutParams(params);
			tv.setGravity(Gravity.CENTER | Gravity.BOTTOM);

			TextView tv2 = new TextView(this.getActivity());

			tv2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 50));
			tv2.setText("Visit www.laffportal.com");

			tv2.setTextAppearance(this.getActivity(), R.style.ImageTitle);

			tv2.setBackgroundResource(R.color.Textcolor);
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
			params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, tv2.getId());
			tv2.setLayoutParams(params2);

			tv2.setGravity(Gravity.CENTER | Gravity.BOTTOM);
			
			rv.addView(lImageView);
			rv1.addView(lImageView1);
			rv2.addView(lImageView2);
			rv3.addView(lImageView3);
			rv4.addView(lImageView4);
			rv5.addView(lImageView5);
			rv6.addView(lImageView6);
			rv7.addView(lImageView7);
			// rv.addView(lImageView6);
			rv.addView(tv);
			rv7.addView(tv2);
			mViewFlipper.addView(rv);
			mViewFlipper.addView(rv1);
			mViewFlipper.addView(rv2);
			mViewFlipper.addView(rv3);
			mViewFlipper.addView(rv4);
			mViewFlipper.addView(rv5);
			mViewFlipper.addView(rv6);
			mViewFlipper.addView(rv7);

			mViewFlipper.setOnTouchListener(new OnTouchListener() {
				@Override
				public boolean onTouch(final View view, final MotionEvent event) {
					detector.onTouchEvent(event);
					return true;
				}
			});
		} catch (IOException ex) {
			Log.e("THE IO", ex.toString());
		}

		// //animation listener
		mAnimationListener = new Animation.AnimationListener() {
			public void onAnimationStart(Animation animation) {
				// animation started event
			}

			public void onAnimationRepeat(Animation animation) {
			}

			public void onAnimationEnd(Animation animation) {
				// TODO animation stopped event
			}
		};

		return rootView;
	}

	class SwipeGestureDetector extends SimpleOnGestureListener {
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			try {
				// right to left swipe
				if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
						&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(
							mContext, R.anim.left_in));
					mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(
							mContext, R.anim.left_out));
					// controlling animation
					mViewFlipper.getInAnimation().setAnimationListener(
							mAnimationListener);
					mViewFlipper.showNext();
					return true;
				} else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
						&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(
							mContext, R.anim.right_in));
					mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(
							mContext, R.anim.right_out));
					// controlling animation
					mViewFlipper.getInAnimation().setAnimationListener(
							mAnimationListener);
					mViewFlipper.showPrevious();
					return true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
		}
	}

	public static class LoaderImageView extends RelativeLayout {
		private Context context;
		private ProgressBar progressBar;
		private ImageView imageView;
		private Bitmap mDrawable;
		private int imageOrder;

		private static final int COMPLETE = 0;
		private static final int FAILED = 1;

		public LoaderImageView(final Context context, String imageUrl,
				int imageOrder) throws IOException {
			super(context);
			instantiate(context, imageUrl, imageOrder);
		}

		// public void setImageResource(int imageResID) {
		// imageView.setImageResource(imageResID);
		//
		// }

		private void instantiate(final Context _context, final String imageUrl,
				final int imageOrder) throws IOException {
			context = _context;

			// li.add(getimages(imageUrl));

			imageView = new ImageView(context);

			imageView.setLayoutParams(new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

			imageView.setAdjustViewBounds(true);

			progressBar = new ProgressBar(context);
			progressBar.setLayoutParams(new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			progressBar.setIndeterminate(true);

			addView(progressBar);
			addView(imageView);
			if (imageUrl != null) {

				setImageDrawable(imageUrl, imageOrder);
			}

		}

		// this.setGravity(Gravity.CENTER);

		/**
		 * Set's the view's drawable, this uses the internet to retrieve the
		 * image don't forget to add the correct permissions to your manifest
		 * 
		 * @param imageUrl
		 *            the url of the image you wish to load
		 */
		public void setImageDrawable(final String imageUrl, final int imageOrder) {
			mDrawable = null;
			progressBar.setVisibility(View.VISIBLE);
			imageView.setVisibility(View.GONE);
			new Thread() {
				public void run() {
					try {
						Document doc = Jsoup.connect(imageUrl)

						.timeout(69999).get();

						Elements element = doc.select(".flexslider .slides li");
						ArrayList<String> li = new ArrayList<String>();
						for (Element eimageUrl : element) {
							String s2ImageUrl = imageUrl
									+ eimageUrl.select("a img").eq(0)
											.attr("src");
							li.add(s2ImageUrl);

						}
						Log.v("url", li.get(imageOrder).trim());
						// sImageUrl = s2ImageUrl;
						mDrawable = getDrawableFromUrl(li.get(imageOrder)
								.trim());
						imageLoadedHandler.sendEmptyMessage(COMPLETE);

					} catch (MalformedURLException e) {
						imageLoadedHandler.sendEmptyMessage(FAILED);
					} catch (IOException e) {
						imageLoadedHandler.sendEmptyMessage(FAILED);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};
			}.start();
		}

		/**
		 * Callback that is received once the image has been downloaded
		 */
		private final Handler imageLoadedHandler = new Handler(new Callback() {
			@Override
			public boolean handleMessage(Message msg) {
				switch (msg.what) {
				case COMPLETE:
					imageView.setImageBitmap(mDrawable);
					imageView.setVisibility(View.VISIBLE);
					progressBar.setVisibility(View.GONE);
					break;
				case FAILED:
				default:
					// Could change image here to a 'failed' image
					// otherwise will just keep on spinning
					break;
				}
				return true;
			}
		});

		/**
		 * Pass in an image url to get a drawable object
		 * 
		 * @return a drawable object
		 * @throws Exception
		 * @throws IOException
		 * @throws MalformedURLException
		 */
		// private static Drawable getDrawableFromUrl(final String url)
		// throws IOException, MalformedURLException {
		// return Drawable.createFromStream(
		// ((java.io.InputStream) new java.net.URL(url).getContent()),
		// "name");
		// }
		//
		// public static Drawable getDrawableFromUrl(String url) throws
		// IOException {
		// Bitmap x;
		//
		// HttpURLConnection connection = (HttpURLConnection) new
		// URL(url).openConnection();
		//
		// connection.connect();
		// InputStream input = connection.getInputStream();
		// //
		// x = BitmapFactory.decodeStream(input);
		// input.reset();
		// return new BitmapDrawable(x);
		// }
		//
		private Bitmap getDrawableFromUrl(String url) throws Exception {
			try {
				String urlE = url.replaceAll(" ", "%20");
				InputStream is = null;
				HttpURLConnection connection = (HttpURLConnection) new URL(urlE)
						.openConnection();
				//
				connection.connect();
				connection.setInstanceFollowRedirects(false);
				int responseCode = connection.getResponseCode(); // can call
																	// this
																	// instead
																	// of
																	// con.connect()
				if (responseCode >= 400 && responseCode <= 499) {
					throw new Exception("Bad authentication status: "
							+ responseCode + urlE); // provide a more meaningful
													// exception message

				} else {
					is = connection.getInputStream();
					
					
					BitmapFactory.Options options=new BitmapFactory.Options();
					options.inSampleSize = 4;
					options.inPurgeable=true;
					options.inInputShareable=true;
					Bitmap d=BitmapFactory.decodeStream(is,null,options);
					
					

					return d;
				}

			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	// public String getimages(final String imageUrl,final int imageOrder)
	// throws IOException {
	// final String sImageUrl = "";
	// new Thread() {
	//
	// public void run() {
	// try {
	// Document doc;
	//
	// doc = Jsoup.connect(imageUrl)
	//
	// .timeout(69999).get();
	//
	// Elements elements = doc.body().select(
	// ".flexslider .slides li a img:eq("+imageOrder+")");
	//
	// String s2ImageUrl;
	// for (Element eimageUrl : elements) {
	// s2ImageUrl = imageUrl + eimageUrl.attr("src");
	// //sImageUrl = s2ImageUrl;
	// Log.v("2nd test", sImageUrl);
	//
	// }
	// } catch (IOException e) {
	// Log.e("IOEXCEPTION", e.toString());
	// }
	// };
	// }.start();
	// Log.v("2nd test", sImageUrl);
	// return sImageUrl;
	//
	// }
	//
	// private static int getSizeCount(final String imageUrl) throws IOException
	// {
	// final ArrayList<String> li = new ArrayList<String>();
	// new Thread() {
	// public void run() {
	// try {
	// Document doc;
	//
	// doc = Jsoup.connect(imageUrl)
	//
	// .timeout(69999).get();
	//
	// Elements elements = doc.body().select(
	// ".flexslider .slides li a img");
	// String sImageUrl = null;
	//
	// for (Element eimageUrl : elements) {
	// sImageUrl = imageUrl + eimageUrl.attr("src");
	// li.add(sImageUrl);
	// }
	// } catch (IOException e) {
	// Log.e("IOEXCEPTION", e.toString());
	// }
	// };
	// }.start();
	// // Log.v("urls test error", sImageUrl);
	//
	// return li.size();
	// }
	// private class LongOperation extends AsyncTask<String, Void, String> {
	//
	// @Override
	// protected String doInBackground(String... params) {
	// for (int i = 0; i < 5; i++) {
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException e) {
	// Thread.interrupted();
	// }
	// }
	// return "Executed";
	// }
	//
	// @Override
	// protected void onPostExecute(String result) {
	// TextView txt = (TextView) findViewById(R.id.output);
	// txt.setText("Executed"); // txt.setText(result);
	// // might want to change "executed" for the returned string passed
	// // into onPostExecute() but that is upto you
	// }
	//
	// @Override
	// protected void onPreExecute() {
	// }
	//
	// @Override
	// protected void onProgressUpdate(Void... values) {
	// }
	// }
}
