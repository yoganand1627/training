/**
 * These functions are used to create the countdown timer in the status bar of IMPACT.
 */

function resetTimeout()
{
  g_nSessionTimeout = 30; // time out in minutes
  g_nStopMinutes    = ( g_nSessionTimeout - 1 );
  g_nStopSeconds    = 59;
}
var g_nSessionTimeout = 30; //<%-- time out in minutes --%>
var g_nSessionWarn    = 25; //<%--when to warn ** g_nSessionTimeout - g_nSessionWarn = displayed time when warning is displayed--%>
var g_nStopMinutes    = ( g_nSessionTimeout - 1 );
var g_nStopSeconds    = 59;

function stop()
{
   clearTimeout(tick);
}

function sessionTimer()
{
  if ( g_nSessionTimeout != 0 )
  {
  if ( g_nStopSeconds == 0 )
  {
    g_nStopSeconds = 59;
    g_nStopMinutes = ( g_nStopMinutes - 1 );
    if ( g_nStopMinutes == ( ( g_nSessionTimeout - g_nSessionWarn) - 1 ) )
    {
      window.showModelessDialog("/grnds-docs/SessionTimeoutWarning.html", "","dialogHeight: 140px; dialogWidth: 425px; edge: Raised; center: Yes; help: No; resizable: No; status: No;");
    }
  }
  else
    g_nStopSeconds = (g_nStopSeconds - 1);

  if (g_nStopSeconds <= 9)
    g_nStopSeconds = "0" + g_nStopSeconds;

  window.status = ('Your Session Will Time Out In ' + g_nStopMinutes + ':' + g_nStopSeconds );

  if ( ( g_nStopMinutes == 0) && ( g_nStopSeconds == 0) )
  {
    window.status = 'Your sesson has been disconnected';
  }
  else
    setTimeout( "sessionTimer()",1000 );
  }
}
sessionTimer();

