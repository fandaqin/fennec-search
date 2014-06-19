package org.mozilla.search.stream;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.mozilla.search.R;


public class CardStreamFragment extends ListFragment {


  /**
   * Mandatory empty constructor for the fragment manager to instantiate the
   * fragment (e.g. upon screen orientation changes).
   */
  public CardStreamFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ArrayAdapter<PreloadAgent.TmpItem> adapter = new ArrayAdapter<PreloadAgent.TmpItem>(getActivity(),
        R.layout.card, R.id.card_title, PreloadAgent.ITEMS) {

      /**
       * Return false here disables the ListView from highlighting the click events
       * for each of the items. Each card should handle its own click events.
       */
      @Override
      public boolean isEnabled(int position) {
        return false;
      }
    };
    setListAdapter(adapter);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    // Remove horizontal line between each card.
    getListView().setDivider(null);
  }

  @Override
  public void onDetach() {
    super.onDetach();
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
  }

  public void handleSearch(String s) {

    String url = "https://search.yahoo.com/search?p=" + s;
    Intent i = new Intent(Intent.ACTION_VIEW);
    i.setData(Uri.parse(url));
    startActivity(i);
  }
}
