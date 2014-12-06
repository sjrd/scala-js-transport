package transport.jsapi

import scala.scalajs.js

class MediaStreamConstraints extends js.Object {
  val audio: js.Any = js.native
  val video: js.Any = js.native
}

object MediaStreamConstraints extends js.Object {
}

class MediaTrackConstraints extends js.Object {
  val mandatory: MediaTrackConstraintSet = js.native
  val optional: js.Array[MediaTrackConstraint] = js.native
}

object MediaTrackConstraints extends js.Object {
}

class MediaTrackConstraintSet extends js.Object {
}

object MediaTrackConstraintSet extends js.Object {
}

trait MediaTrackConstraint extends js.Object {
}

object MediaTrackConstraint extends js.Object {
/* ??? ConstructorMember(FunSignature(List(),List(),Some(TypeRef(TypeName(MediaTrackConstraints),List())))) */
}

trait Navigator extends js.Object {
  def getUserMedia(constraints: MediaStreamConstraints, successCallback: js.Function1[js.Any, Unit], errorCallback: js.Function1[Error, Unit]): Unit = js.native
  def webkitGetUserMedia(constraints: MediaStreamConstraints, successCallback: js.Function1[js.Any, Unit], errorCallback: js.Function1[Error, Unit]): Unit = js.native
}

trait EventHandler extends js.Object {
  def apply(event: Event): Unit = js.native
}

trait NavigatorUserMediaSuccessCallback extends js.Object {
  def apply(stream: LocalMediaStream): Unit = js.native
}

class NavigatorUserMediaError extends js.Object {
  val PERMISSION_DENIED: js.Number = js.native
  val code: js.Number = js.native
}

object NavigatorUserMediaError extends js.Object {
  val PERMISSION_DENIED: js.Number = js.native
}

trait NavigatorUserMediaErrorCallback extends js.Object {
  def apply(error: NavigatorUserMediaError): Unit = js.native
}

class MediaStreamTrackList extends js.Object {
  val length: js.Number = js.native
  val item: MediaStreamTrack = js.native
  def add(track: MediaStreamTrack): Unit = js.native
  def remove(track: MediaStreamTrack): Unit = js.native
  val onaddtrack: js.Function1[Event, Unit] = js.native
  val onremovetrack: js.Function1[Event, Unit] = js.native
}

object MediaStreamTrackList extends js.Object {
}

object webkitMediaStreamTrackList extends js.Object {
/* ??? ConstructorMember(FunSignature(List(),List(),Some(TypeRef(TypeName(MediaStreamTrackList),List())))) */
}

class MediaStream extends js.Object {
  def this(trackContainers: js.Array[MediaStream]) = this()
  val label: js.String = js.native
  val id: js.String = js.native
  def getAudioTracks(): MediaStreamTrackList = js.native
  def getVideoTracks(): MediaStreamTrackList = js.native
  val ended: js.Boolean = js.native
  val onended: js.Function1[Event, Unit] = js.native
}

object MediaStream extends js.Object {
}

object webkitMediaStream extends js.Object {
/* ??? ConstructorMember(FunSignature(List(),List(),Some(TypeRef(TypeName(MediaStream),List())))) */
/* ??? ConstructorMember(FunSignature(List(),List(FunParam(Ident(trackContainers),false,Some(TypeRef(TypeName(Array),List(TypeRef(TypeName(MediaStream),List())))))),Some(TypeRef(TypeName(MediaStream),List())))) */
/* ??? ConstructorMember(FunSignature(List(),List(FunParam(Ident(trackContainers),false,Some(TypeRef(TypeName(Array),List(TypeRef(TypeName(MediaStreamTrackList),List())))))),Some(TypeRef(TypeName(MediaStream),List())))) */
/* ??? ConstructorMember(FunSignature(List(),List(FunParam(Ident(trackContainers),false,Some(TypeRef(TypeName(Array),List(TypeRef(TypeName(MediaStreamTrack),List())))))),Some(TypeRef(TypeName(MediaStream),List())))) */
}

trait SourceInfo extends js.Object {
  val label: js.String = js.native
  val id: js.String = js.native
  val kind: js.String = js.native
  val facing: js.String = js.native
}

object SourceInfo extends js.Object {
}

trait LocalMediaStream extends MediaStream {
  def stop(): Unit = js.native
}

class MediaStreamTrack extends js.Object {
  val kind: js.String = js.native
  val label: js.String = js.native
  val enabled: js.Boolean = js.native
  val LIVE: js.Number = js.native
  val MUTED: js.Number = js.native
  val ENDED: js.Number = js.native
  val readyState: js.Number = js.native
  val onmute: js.Function1[Event, Unit] = js.native
  val onunmute: js.Function1[Event, Unit] = js.native
  val onended: js.Function1[Event, Unit] = js.native
}

object MediaStreamTrack extends js.Object {
  val LIVE: js.Number = js.native
  val MUTED: js.Number = js.native
  val ENDED: js.Number = js.native
  val getSources: js.Function1[js.Function1[js.Array[SourceInfo], Unit], Unit] = js.native
}

trait streamURL extends js.Object {
  def createObjectURL(stream: MediaStream): js.String = js.native
}

trait WebkitURL extends streamURL {
}

object webkitURL extends js.Object {
/* ??? ConstructorMember(FunSignature(List(),List(),Some(TypeRef(TypeName(streamURL),List())))) */
  def createObjectURL(stream: MediaStream): js.String = js.native
}
